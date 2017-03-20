package com.stessi.elo.entity;

import javax.persistence.*;

/**
 * An entity to represent competition player database entity
 *
 * @author palmithor
 * @since 7.3.2017.
 */
@Entity(name = "competition_players")
public class CompetitionPlayerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "competition_players_id_seq")
    @SequenceGenerator(name = "competition_players_id_seq", sequenceName = "competition_players_id_seq")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerEntity player;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private CompetitionEntity competition;

    @Column(name = "rating")
    private Integer rating;

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(final PlayerEntity player) {
        this.player = player;
    }

    public CompetitionEntity getCompetition() {
        return competition;
    }

    public void setCompetition(final CompetitionEntity competition) {
        this.competition = competition;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(final Integer rating) {
        this.rating = rating;
    }
}

