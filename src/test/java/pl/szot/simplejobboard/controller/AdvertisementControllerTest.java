package pl.szot.simplejobboard.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import pl.szot.simplejobboard.model.Advertisement;
import pl.szot.simplejobboard.service.AdvertisementService;
import pl.szot.simplejobboard.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class AdvertisementControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    AdvertisementService advertisementService;
    @MockBean
    UserService userService;

    @Test
    void getAdvertisementShouldReturn200AnonymousAccessScenario() throws Exception {
        Advertisement advertisement = new Advertisement.Builder().id(2L).hidden(false).title("title").content("content").build();
        Mockito.when(advertisementService.findById(Mockito.any())).thenReturn(java.util.Optional.ofNullable(advertisement));
        mockMvc.perform(get("/api/v1/advertisements/2")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin")
    void getAdvertisementShouldReturn200AdminAccessScenario() throws Exception {
        Advertisement advertisement = new Advertisement.Builder().id(2L).hidden(true).title("title").content("content").build();
        Mockito.when(advertisementService.findById(Mockito.any())).thenReturn(java.util.Optional.ofNullable(advertisement));
        mockMvc.perform(get("/api/v1/advertisements/2")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getAdvertisementShouldReturn404AnonymousAccessScenario() throws Exception {
        Advertisement advertisement = new Advertisement.Builder().id(2L).hidden(true).title("title").content("content").build();
        Mockito.when(advertisementService.findById(Mockito.any())).thenReturn(java.util.Optional.ofNullable(advertisement));
        mockMvc.perform(get("/api/v1/advertisements/2")).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "admin")
    void getAdvertisementShouldReturn404AdminAccessScenario() throws Exception {
        Mockito.when(advertisementService.findById(Mockito.any())).thenReturn(Optional.empty());
        mockMvc.perform(get("/api/v1/advertisements/2")).andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    void getAdvertisementsShouldReturn200AnonymousAccessScenario() throws Exception {
        List<Advertisement> advertisements = new ArrayList<>();
        advertisements.add(new Advertisement.Builder().id(2L).hidden(true).title("title").content("content").build());
        Mockito.when(advertisementService.findAllNotExpiredAndNotHidden(0, 100)).thenReturn(new PageImpl<Advertisement>(advertisements));
        mockMvc.perform(get("/api/v1/advertisements?pageNo=0&pageSize=100"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("content")));
    }

    @Test
    @WithMockUser(username = "admin")
    void getAdvertisementsShouldReturn200AdminAccessScenario() throws Exception {
        List<Advertisement> advertisements = new ArrayList<>();
        advertisements.add(new Advertisement.Builder().id(2L).hidden(true).title("title").content("content").build());
        Mockito.when(advertisementService.findAll(0, 100)).thenReturn(new PageImpl<Advertisement>(advertisements));
        mockMvc.perform(get("/api/v1/advertisements?pageNo=0&pageSize=100"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("content")));
    }

    @Test
    @WithMockUser(username = "admin")
    void updateShouldReturn200() throws Exception {
        Advertisement advertisement = new Advertisement.Builder().id(2L).hidden(true).title("title").content("content").build();
        Mockito.when(advertisementService.findById(Mockito.any())).thenReturn(java.util.Optional.ofNullable(advertisement));
        Mockito.when(advertisementService.save(Mockito.any())).thenReturn(advertisement);
        mockMvc.perform(post("/api/v1/advertisements/2").contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"admin\",\"content\":\"admin\",\"expirationDate\":\"2023-02-06T03:45:42.01\",\"hidden\":true}"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin")
    void updateShouldReturn401() throws Exception {
        Advertisement advertisement = new Advertisement.Builder().id(2L).hidden(true).title("title").content("content").build();
        Mockito.when(advertisementService.findById(Mockito.any())).thenReturn(java.util.Optional.ofNullable(advertisement));
        Mockito.when(advertisementService.save(Mockito.any())).thenReturn(advertisement);
        mockMvc.perform(post("/api/v1/advertisements/2").contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"admin\"onDate\":\"2023-02-06T03:45:42.01\",\"hidden\":true}"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(username = "admin")
    void updateShouldReturn404() throws Exception {
        Advertisement advertisement = new Advertisement.Builder().id(2L).hidden(true).title("title").content("content").build();
        Mockito.when(advertisementService.findById(Mockito.any())).thenReturn(java.util.Optional.empty());
        Mockito.when(advertisementService.save(Mockito.any())).thenReturn(advertisement);
        mockMvc.perform(post("/api/v1/advertisements/2").contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"admin\",\"content\":\"admin\",\"expirationDate\":\"2023-02-06T03:45:42.01\",\"hidden\":true}"))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "admin")
    void createShouldReturn200() throws Exception {
        Advertisement advertisement = new Advertisement.Builder().id(2L).hidden(true).title("title").content("content").build();
        Mockito.when(advertisementService.save(Mockito.any())).thenReturn(advertisement);
        mockMvc.perform(post("/api/v1/advertisements").contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"admin\",\"content\":\"admin\",\"expirationDate\":\"2023-02-06T03:45:42.01\",\"hidden\":true}"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin")
    void createShouldReturn401() throws Exception {
        Advertisement advertisement = new Advertisement.Builder().id(2L).hidden(true).title("title").content("content").build();
        Mockito.when(advertisementService.save(Mockito.any())).thenReturn(advertisement);
        mockMvc.perform(post("/api/v1/advertisements").contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"admin\",\"conteate\":\"2023-02-06T03:45:42.01\",\"hidden\":true}"))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(username = "admin")
    void deleteShouldReturn200() throws Exception {
        mockMvc.perform(delete("/api/v1/advertisements/2"))
                .andDo(print()).andExpect(status().isOk());
    }
}