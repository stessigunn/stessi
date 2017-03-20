package com.stessi.elo.repository;

import com.stessi.elo.entity.CompetitionEntity;
import com.stessi.elo.entity.MatchEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

/**
 * An crud repository for MatchEntity
 * <p>
 * See {@link CrudRepository}
 *
 * @author palmithor
 * @since 7.3.2017.
 */
public interface MatchRepository extends CrudRepository<MatchEntity, Long> {

}
