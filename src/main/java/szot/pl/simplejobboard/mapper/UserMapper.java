package szot.pl.simplejobboard.mapper;

import org.springframework.stereotype.Component;
import szot.pl.simplejobboard.dto.UserDTO;
import szot.pl.simplejobboard.model.User;
import szot.pl.simplejobboard.service.UserService;

/**
 * Map User to the UserDTO and UserDTO to the User
 *
 * @author Kacper Szot
 */
@Component
public class UserMapper implements Mapper<User, UserDTO> {
    private UserService userService;

    public UserMapper(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get User DTO from User Entity
     * @param entity entity to map to the DTO
     * @return UserDTO created from User entity
     */
    @Override
    public UserDTO mapToDto(User entity) {
        return new UserDTO(entity.getId(), entity.getUsername(), entity.getEmail());
    }

    /**
     * Get Entity from DTO, method is retrieving missing information from user service by DTO id
     *
     * @param dto DTO to map to the entity
     * @return Entity for given DTO, or new User if DTO is null
     */
    @Override
    public User mapToEntity(UserDTO dto) {
        User user = userService.findUserById(dto.getId()).orElse(new User());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        return user;
    }
}
