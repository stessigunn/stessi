package com.stessi.elo.repository;

import com.stessi.elo.entity.CompetitionEntity;
import com.stessi.elo.entity.PlayerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.stream.Stream;

/**
 * An crud repository for Competition
 * <p>
 * See {@link CrudRepository}
 *
 * @author palmithor
 * @since 7.3.2017.
 */
public interface CompetitionRepository extends CrudRepository<CompetitionEntity, Long> {

    List<CompetitionEntity> findAll();
}
