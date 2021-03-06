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
public interface PlayerRepository extends CrudRepository<PlayerEntity, Long> {


}
