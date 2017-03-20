package com.stessi.elo.entity;

import javax.persistence.*;

/**
 * An entity to represent match database entity
 *
 * @author palmithor
 * @since 7.3.2017.
 */
@Entity(name = "matches")
public class MatchEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "match_id_seq")
    @SequenceGenerator(name = "match_id_seq", sequenceName = "match_id_seq")
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "competition_id", referencedColumnName = "id", nullable = false)
    private CompetitionEntity competition;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "home_player_id", referencedColumnName = "id", nullable = false)
    private PlayerEntity homePlayer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "away_player_id", referencedColumnName = "id", nullable = false)
    private PlayerEntity awayPlayer;

    @Column(name = "home_score", nullable = false)
    private Integer homeScore;

    @Column(name = "away_score", nullable = false)
    private Integer awayScore;

    public MatchEntity() {
    }

    public MatchEntity(final PlayerEntity homePlayer, final PlayerEntity awayPlayer, final Integer homeScore, final Integer awayScore) {
        this.homePlayer = homePlayer;
        this.awayPlayer = awayPlayer;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public Long getId() {
        return id;
    }

    public PlayerEntity getHomePlayer() {
        return homePlayer;
    }

    public void setHomePlayer(final PlayerEntity homePlayer) {
        this.homePlayer = homePlayer;
    }

    public PlayerEntity getAwayPlayer() {
        return awayPlayer;
    }

    public void setAwayPlayer(final PlayerEntity awayPlayer) {
        this.awayPlayer = awayPlayer;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(final Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(final Integer awayScore) {
        this.awayScore = awayScore;
    }
}
