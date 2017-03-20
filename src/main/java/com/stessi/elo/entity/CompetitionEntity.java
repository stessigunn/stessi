package com.stessi.elo.entity;

import com.stessi.elo.controllers.request.CompetitionRequest;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

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
    @SequenceGenerator(name = "competition_id_seq", sequenceName = "competition_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "competition", targetEntity = MatchEntity.class, fetch = FetchType.EAGER)
    private Set<MatchEntity> matches;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private CompetitionTypeEntity type;

    @OneToMany(mappedBy = "competition")
    private Set<CompetitionPlayerEntity> competitionPlayers;

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

    public Set<MatchEntity> getMatches() {
        return matches;
    }

    public void setMatches(final Set<MatchEntity> matches) {
        this.matches = matches;
    }

    public CompetitionTypeEntity getType() {
        return type;
    }

    public void setType(final CompetitionTypeEntity type) {
        this.type = type;
    }

    public Set<CompetitionPlayerEntity> getCompetitionPlayers() {
        return competitionPlayers;
    }

    public void setCompetitionPlayers(final Set<CompetitionPlayerEntity> competitionPlayers) {
        this.competitionPlayers = competitionPlayers;
    }
}
