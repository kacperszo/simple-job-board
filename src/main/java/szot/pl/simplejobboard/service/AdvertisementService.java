package szot.pl.simplejobboard.service;

import org.springframework.data.domain.Page;
import szot.pl.simplejobboard.model.Advertisement;

import java.util.Optional;

/**
 * Service offers an interface for manipulating advertisements
 *
 * @author Kacper Szot
 */

public interface AdvertisementService {
    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the entity instance completely.
     *
     * @param advertisement advertisement
     * @return the saved advertisement; will never be null.
     * @throws IllegalArgumentException in case the given advertisement is null.
     */
    Advertisement save(Advertisement advertisement);

    /**
     * Returns a Page of advertisements meeting the paging restriction provided in arguments
     *
     * @param pageNumber number of page cannot be null
     * @param pageSize   size of page cannot be null
     * @return a page of advertisements
     */
    Page<Advertisement> findAll(int pageNumber, int pageSize);

    /**
     * Returns a Page of advertisements that are not expired meeting the paging restriction provided in arguments
     *
     * @param pageNumber number of page cannot be null
     * @param pageSize   size of page cannot be null
     * @return a page of advertisements
     */
    Page<Advertisement> findAllNotExpired(int pageNumber, int pageSize);

    /**
     * Returns a Page of advertisements that are not expired meeting the paging restriction provided in arguments
     *
     * @param pageNumber number of page cannot be null
     * @param pageSize   size of page cannot be null
     * @return a page of advertisements
     */
    Page<Advertisement> findAllNotExpiredAndNotHidden(int pageNumber, int pageSize);

    /**
     * Returns a Page of advertisements that are not expired meeting the paging restriction provided in arguments
     *
     * @param pageNumber number of page cannot be null
     * @param pageSize   size of page cannot be null
     * @return a page of advertisements
     */
    Page<Advertisement> findAllNotHidden(int pageNumber, int pageSize);

    /**
     * Returns a Page of advertisements meeting the paging restriction provided in arguments and containing query in the advertisement's title.
     *
     * @param pageNumber number of page cannot be null
     * @param pageSize   size of page cannot be null
     * @param query      cannot be null
     * @return a page of advertisements
     */
    Page<Advertisement> search(int pageNumber, int pageSize, String query);

    /**
     * Retrieves an advertisement by its id.
     *
     * @param id must not be null.
     * @return the advertisement with the given id or Optional#empty() if none found.
     */
    Optional<Advertisement> findById(Long id);

    /**
     * Deletes a given advertisement.
     *
     * @param advertisement must not be null.
     * @throws IllegalArgumentException in case the given advertisement is null.
     */
    void delete(Advertisement advertisement);

    /**
     * Deletes the advertisement with the given id.
     *
     * @param id must not be null.
     * @throws IllegalArgumentException in case the given id is null
     */
    void deleteById(Long id);
}
