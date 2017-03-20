package com.stessi.elo.entity;

import com.stessi.elo.model.Competition;

import javax.persistence.*;
import java.util.Set;

/**
 * An entity to represent competition type database entity
 *
 * @author palmithor
 * @since 7.3.2017.
 */
@Entity(name = "competition_types")
public class CompetitionTypeEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "competition_type_id_seq")
    @SequenceGenerator(name = "competition_type_id_seq", sequenceName = "competition_type_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "type", targetEntity = CompetitionEntity.class)
    private Set<CompetitionEntity> competitions;

    public CompetitionTypeEntity() {
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

    public Set<CompetitionEntity> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(final Set<CompetitionEntity> competitions) {
        this.competitions = competitions;
    }
}
