package com.stessi.elo.entity;

import javax.persistence.*;

/**
 * An entity to represent player database entity
 *
 * @author palmithor
 * @since 7.3.2017.
 */
@Entity(name = "players")
public class PlayerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_id_seq")
    @SequenceGenerator(name="player_id_seq", sequenceName = "player_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public PlayerEntity() {
    }

    public PlayerEntity(final String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
