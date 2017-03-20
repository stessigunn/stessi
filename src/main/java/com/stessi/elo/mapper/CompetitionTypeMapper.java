package com.stessi.elo.mapper;

import com.stessi.elo.entity.CompetitionTypeEntity;
import com.stessi.elo.model.CompetitionType;

/**
 * @author palmithor
 * @since 9.3.2017.
 */
public class CompetitionTypeMapper {

    private CompetitionTypeMapper() {}


    public static CompetitionType mapEntityToModel(final CompetitionTypeEntity type) {
        return CompetitionType.create()
                .id(type.getId()).created(type.getCreated()).updated(type.getUpdated())
                .name(type.getName())
                .build();
    }
}
