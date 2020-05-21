package pl.szot.simplejobboard.mapper;

import org.springframework.stereotype.Component;
import pl.szot.simplejobboard.dto.AdvertisementDTO;
import pl.szot.simplejobboard.model.Advertisement;

/**
 * Map Advertisement to the AdvertisementDTO and AdvertisementDTO to the Advertisement
 *
 * @author Kacper Szot
 */
@Component
public class AdvertisementMapper implements Mapper<Advertisement, AdvertisementDTO> {
    /**
     * Map entity to the data transfesr objects
     *
     * @param entity entity to map to the DTO
     * @return AdvertisementDTO
     */
    @Override
    public AdvertisementDTO mapToDto(Advertisement entity) {
        return new AdvertisementDTO(entity.getId(), entity.getTitle(), entity.getContent(), entity.getCreationDate(), entity.getExpirationDate(), entity.isHidden());
    }

    /**
     * Map data transfer objects to the entity
     *
     * @param dto DTO to map to the entity
     * @return Advertisement
     */
    @Override
    public Advertisement mapToEntity(AdvertisementDTO dto) {
        return new Advertisement(dto.getId(), dto.getTitle(), dto.getContent(), dto.getCreationDate(), dto.getExpirationDate(), dto.isHidden());
    }
}
