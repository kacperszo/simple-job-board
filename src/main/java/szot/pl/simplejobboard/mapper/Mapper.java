package szot.pl.simplejobboard.mapper;

/**
 * Mapper interface, map DTO object to the entities and entities to the DTO objects
 *
 * @param <E> Entity class
 * @param <D> DTO class
 * @author Kacper Szot
 */
public interface Mapper<E, D> {
    /**
     * Map entity to the data transfer objects
     *
     * @param entity entity to map to the DTO
     * @return DTO
     */
    D mapToDto(E entity);

    /**
     * Map data transfer objects to the entity
     *
     * @param dto DTO to map to the entity
     * @return Entity object
     */
    E mapToEntity(D dto);
}
