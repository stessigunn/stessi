package com.stessi.elo.model;

import java.util.Date;

/**
 * @author palmithor
 * @since 8.3.2017.
 */
abstract class BaseModel {

    private final Long id;
    private final Date updated;
    private final Date created;

    BaseModel() {
        this.id = null;
        this.updated = null;
        this.created = null;
    }

    BaseModel(final Long id, final Date updated, final Date created) {
        this.id = id;
        this.updated = updated;
        this.created = created;
    }
}
