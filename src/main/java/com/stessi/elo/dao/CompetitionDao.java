package com.stessi.elo.dao;

import com.stessi.elo.controllers.exception.ResourceNotFoundException;
import com.stessi.elo.controllers.request.CompetitionRequest;
import com.stessi.elo.entity.CompetitionEntity;
import com.stessi.elo.entity.CompetitionTypeEntity;
import com.stessi.elo.mapper.CompetitionMapper;
import com.stessi.elo.mapper.ObjectMapper;
import com.stessi.elo.model.Competition;
import com.stessi.elo.repository.CompetitionRepository;
import com.stessi.elo.repository.CompetitionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author palmithor
 * @since 8.3.2017.
 */
@Service
public class CompetitionDao extends BaseDao<CompetitionRequest, Competition, CompetitionEntity> {

    @Autowired
    public CompetitionDao(final CompetitionMapper competitionMapper) {
        super(competitionMapper);
    }
}
