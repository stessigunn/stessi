package com.stessi.elo.entity;

import javax.persistence.*;

/**
 * An entity to represent match player database entity
 *
 * @author palmithor
 * @since 7.3.2017.
 */
@Entity(name = "match_players")
public class MatchPlayerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "match_players_id_seq")
    @SequenceGenerator(name = "match_players_id_seq", sequenceName = "match_players_id_seq")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private MatchEntity match;

    @Column(name = "home_team")
    private boolean isHomeTeam;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(final PlayerEntity player) {
        this.player = player;
    }

    public MatchEntity getMatch() {
        return match;
    }

    public void setMatch(final MatchEntity match) {
        this.match = match;
    }

    public boolean isHomeTeam() {
        return isHomeTeam;
    }

    public void setHomeTeam(final boolean homeTeam) {
        isHomeTeam = homeTeam;
    }
}

