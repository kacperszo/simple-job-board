package pl.szot.simplejobboard.repository;

import org.springframework.data.repository.CrudRepository;
import pl.szot.simplejobboard.model.User;

import java.util.Optional;

/**
 * User repository
 *
 * @author Kacper Szot
 */
public interface UserRepository extends CrudRepository<User, Long> {
    /**
     * Retrieves an optional of user by its username
     *
     * @param username cannot be null
     * @return Optional of user for given id
     */
    Optional<User> findByUsername(String username);
}
