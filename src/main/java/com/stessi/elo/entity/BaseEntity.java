package com.stessi.elo.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * An base entity with fields that are common between all entities
 *
 * @author palmithor
 * @since 7.3.2017.
 */
@MappedSuperclass
abstract class BaseEntity {

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "created", nullable = false)
    private Date created;


    @Column(name = "updated", nullable = false)
    private Date updated;

    @PreUpdate
    void onUpdate() {
        this.updated = new Date();
    }

    @PrePersist
    void onCreate() {
        this.created = new Date();
        this.updated = new Date();
    }

    public Long getVersion() {
        return version;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }
}
