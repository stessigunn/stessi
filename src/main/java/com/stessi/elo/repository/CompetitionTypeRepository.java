package com.stessi.elo.repository;

import com.stessi.elo.entity.CompetitionEntity;
import com.stessi.elo.entity.CompetitionTypeEntity;
import com.stessi.elo.model.CompetitionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.stream.Stream;

/**
 * An crud repository for Competition Type
 * <p>
 * See {@link CrudRepository}
 *
 * @author palmithor
 * @since 7.3.2017.
 */
public interface CompetitionTypeRepository extends CrudRepository<CompetitionTypeEntity, Long> {

}
