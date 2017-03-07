package com.stessi.elo.repository;

import com.stessi.elo.entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.stream.Stream;

/**
 * An crud repository for Players
 * <p>
 * See {@link CrudRepository}
 *
 * @author palmithor
 * @since 7.3.2017.
 */
public interface PlayerRepository extends Repository<PlayerEntity, Long> {


    Stream<PlayerEntity> findAll();

    PlayerEntity findOneById(final Long id);

    PlayerEntity save(final PlayerEntity entity);

    long count();

    void delete(final Long id);
}
