package com.stessi.elo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author palmithor
 * @since 8.3.2017.
 */
public class PlayerStanding {

    @SerializedName("player") private final Player player;
    @SerializedName("rating") private final Integer rating;
    @SerializedName("home_matches") private final List<Match> homeMatches;
    @SerializedName("away_matches") private final List<Match> awayMatches;

    public PlayerStanding() {
        this.player = null;
        this.rating = null;
        this.homeMatches = null;
        this.awayMatches = null;
    }

    public PlayerStanding(final Player player, final Integer score, final List<Match> homeMatches, final List<Match> awayMatches) {
        this.player = player;
        this.rating = score;
        this.homeMatches = homeMatches;
        this.awayMatches = awayMatches;
    }

    public Player getPlayer() {
        return player;
    }

    public Integer getRating() {
        return rating;
    }

    public List<Match> getHomeMatches() {
        return homeMatches;
    }

    public List<Match> getAwayMatches() {
        return awayMatches;
    }

    public static Builder create() {
        return new Builder();
    }


    public static Builder copy(final PlayerStanding playerStanding) {
        return new Builder(playerStanding);
    }


    public static final class Builder {
        private Player player;
        private Integer rating;
        private List<Match> homeMatches;
        private List<Match> awayMatches;

        private Builder() {
        }

        private Builder(final PlayerStanding playerStanding) {
            this.player = playerStanding.getPlayer();
            this.rating = playerStanding.getRating();
            this.homeMatches = playerStanding.getHomeMatches();
            this.awayMatches = playerStanding.getAwayMatches();
        }


        public Builder player(Player player) {
            this.player = player;
            return this;
        }

        public Builder score(Integer score) {
            this.rating = score;
            return this;
        }

        public Builder homeMatches(List<Match> homeMatches) {
            this.homeMatches = homeMatches;
            return this;
        }

        public Builder awayMatches(List<Match> awayMatches) {
            this.awayMatches = awayMatches;
            return this;
        }

        public PlayerStanding build() {
            PlayerStanding playerStanding = new PlayerStanding(player, rating, homeMatches, awayMatches);
            return playerStanding;
        }
    }
}
