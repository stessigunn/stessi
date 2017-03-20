package com.stessi.elo.mapper;

import com.stessi.elo.controllers.request.RestRequest;
import com.stessi.elo.entity.BaseEntity;

/**
 * @author palmithor
 * @since 10.3.2017.
 */
public interface ObjectMapper<Request extends RestRequest, Model, Entity extends BaseEntity> {

    Model mapEntityToModel(final Entity entity);

    Entity mapRequestToEntity(final Request request);

}
