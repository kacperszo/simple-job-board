package szot.pl.simplejobboard.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import szot.pl.simplejobboard.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Service offers an interface for manipulating users
 *
 * @author Kacper Szot
 */
public interface UserService extends UserDetailsService {
    /**
     * Retrieves an user by its id.
     *
     * @param id cannot be null
     * @return
     */
    Optional<User> findUserById(Long id);

    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the entity instance completely.
     *
     * @param user user
     * @return the saved user; will never be null.
     * @throws IllegalArgumentException in case the given advertisement is null.
     */
    User save(User user);

    /**
     * Return list of all users int the system.
     *
     * @return List of all users in the system
     */
    List<User> findAll();

    /**
     * Deletes a given user.
     *
     * @param user cannot be null
     */
    void delete(User user);

    /**
     * Deletes a given user.
     *
     * @param id cannot be null
     */
    void deleteById(Long id);
}
