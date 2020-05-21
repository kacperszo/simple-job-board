package pl.szot.simplejobboard.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.szot.simplejobboard.model.Advertisement;

/**
 * Repository interface for the advertisements
 * @author Kacper Szot
 */
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    /**
     * Find all advertisements
     * @param pageable pagination information
     * @return Page of results
     */
    @Override
    Page<Advertisement> findAll(Pageable pageable);

    /**
     * Find all advertisements which contain the query in the content
     * @param pageable pagination information
     * @param query query to find
     * @return Page of results
     */
    Page<Advertisement> findAllByContentContaining(Pageable pageable, String query);

    /**
     * Find all advertisements which contain the query in the title
     * @param pageable pagination information
     * @param query query to find
     * @return Page of results
     */
    Page<Advertisement> findAllByTitleContaining(Pageable pageable, String query);
}
