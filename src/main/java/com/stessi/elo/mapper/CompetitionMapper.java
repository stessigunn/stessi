package com.stessi.elo.mapper;

import com.stessi.elo.controllers.exception.ResourceNotFoundException;
import com.stessi.elo.controllers.request.CompetitionRequest;
import com.stessi.elo.entity.CompetitionEntity;
import com.stessi.elo.entity.CompetitionPlayerEntity;
import com.stessi.elo.entity.CompetitionTypeEntity;
import com.stessi.elo.model.Competition;
import com.stessi.elo.repository.CompetitionRepository;
import com.stessi.elo.repository.CompetitionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author palmithor
 * @since 9.3.2017.
 */
@Component
public class CompetitionMapper implements ObjectMapper<CompetitionRequest, Competition, CompetitionEntity> {


    @Autowired private CompetitionTypeRepository competitionTypeRepository;
    @Autowired private CompetitionRepository competitionRepository;


    public Competition mapEntityToModel(final CompetitionEntity competitionEntity) {
        return Competition.create()
                .id(competitionEntity.getId()).created(competitionEntity.getCreated()).updated(competitionEntity.getUpdated())
                .name(competitionEntity.getName())
                .type(CompetitionTypeMapper.mapEntityToModel(competitionEntity.getType()))
                .matches(
                        Optional.ofNullable(competitionEntity.getMatches())
                                .orElseGet(Collections::emptySet)
                                .stream()
                                .map(MatchMapper::mapEntityToResponse)
                                .collect(Collectors.toList())
                )
                .standings(
                        Optional.ofNullable(competitionEntity.getCompetitionPlayers())
                                .orElseGet(Collections::emptySet)
                                .stream()
                                .sorted(Comparator.comparingInt(CompetitionPlayerEntity::getRating))
                                .map(PlayerMapper::mapEntityToModel)
                                .collect(Collectors.toList())
                )
                .build();
    }

    @Override
    public CompetitionEntity mapRequestToEntity(final CompetitionRequest request) {
        CompetitionTypeEntity typeEntity = competitionTypeRepository.findOne(request.getTypeId());
        if (typeEntity == null) {
            throw new ResourceNotFoundException();
        }

        CompetitionEntity entity = null;
        if (request.hasId()) {
            entity = competitionRepository.findOne(request.getId());
        }

        if (entity == null) {
            entity = new CompetitionEntity();
        }
        entity.setName(request.getName());
        entity.setType(typeEntity);
        return entity;
    }
}
