package com.stessi.elo.dao;

import com.stessi.elo.controllers.exception.ResourceNotFoundException;
import com.stessi.elo.controllers.request.RestRequest;
import com.stessi.elo.entity.BaseEntity;
import com.stessi.elo.entity.CompetitionEntity;
import com.stessi.elo.mapper.CompetitionMapper;
import com.stessi.elo.mapper.ObjectMapper;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author palmithor
 * @since 10.3.2017.
 */
abstract class BaseDao<Request extends RestRequest, Model, Entity extends BaseEntity> {


    ObjectMapper<Request, Model, Entity> objectMapper;
    CrudRepository<Entity, Long> crudRepository;

    public BaseDao(final ObjectMapper<Request, Model, Entity> objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Model findById(final Long id) {
        Entity entity = crudRepository.findOne(id);
        if (entity == null) {
            throw new ResourceNotFoundException();
        }
        return objectMapper.mapEntityToModel(entity);
    }

    public List<Model> findAll() {
        return StreamSupport.stream(crudRepository.findAll().spliterator(), false)
                .map(objectMapper::mapEntityToModel)
                .collect(Collectors.toList());
    }

    public void delete(final Long id) {
        final Entity entity = crudRepository.findOne(id);
        if (entity == null) {
            throw new ResourceNotFoundException();
        }
        crudRepository.delete(id);
    }

    public Model create(final Request request) {
        Entity entity = objectMapper.mapRequestToEntity(request);
        Entity save = crudRepository.save(entity);
        return objectMapper.mapEntityToModel(save);
    }
}
