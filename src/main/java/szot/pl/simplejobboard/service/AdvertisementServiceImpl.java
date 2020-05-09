package szot.pl.simplejobboard.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import szot.pl.simplejobboard.model.Advertisement;
import szot.pl.simplejobboard.repository.AdvertisementRepository;

import java.util.Optional;

/**
 * implementation of the AdvertisementService
 *
 * @author Kacper Szot
 * @see szot.pl.simplejobboard.service.AdvertisementService
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private AdvertisementRepository advertisementRepository;

    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Advertisement save(Advertisement advertisement) {
        return advertisementRepository.saveAndFlush(advertisement);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Advertisement> findAll(int pageNumber, int pageSize) {
        return advertisementRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Advertisement> search(int pageNumber, int pageSize, String query) {
        return advertisementRepository.findAllByTitleContaining(PageRequest.of(pageNumber, pageSize), query);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Advertisement> findById(Long id) {
        return advertisementRepository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Advertisement advertisement) {
        advertisementRepository.delete(advertisement);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        advertisementRepository.deleteById(id);
    }
}
