package com.stessi.elo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * An entity to represent competition database entity
 *
 * @author palmithor
 * @since 7.3.2017.
 */
@Entity(name = "competitions")
public class CompetitionEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "competition_id_seq")
    @SequenceGenerator(name="competition_id_seq", sequenceName = "competition_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;



    public CompetitionEntity() {
    }

    public CompetitionEntity(final String name) {
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
