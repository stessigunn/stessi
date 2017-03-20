package com.stessi.elo.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * @author palmithor
 * @since 8.3.2017.
 */
public class Competition extends BaseModel {

    @SerializedName("name") private final String name;
    @SerializedName("matches") private final List<Match> matches;
    @SerializedName("standings") private final List<PlayerStanding> standings;
    @SerializedName("type") private final CompetitionType type;

    public Competition() {
        this.name = null;
        this.matches = null;
        this.standings = null;
        this.type = null;
    }

    public Competition(final Long id, final Date updated, final Date created, final String name, final List<Match> matches, final List<PlayerStanding> standings, final CompetitionType type) {
        super(id, updated, created);
        this.name = name;
        this.matches = matches;
        this.standings = standings;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public List<PlayerStanding> getStandings() {
        return standings;
    }

    public CompetitionType getType() {
        return type;
    }

    public static Builder create() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private Date updated;
        private Date created;
        private String name;
        private List<Match> matches;
        private List<PlayerStanding> standings;
        private CompetitionType type;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder updated(Date updated) {
            this.updated = updated;
            return this;
        }

        public Builder created(Date created) {
            this.created = created;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder matches(List<Match> matches) {
            this.matches = matches;
            return this;
        }

        public Builder standings(List<PlayerStanding> standings) {
            this.standings = standings;
            return this;
        }

        public Builder type(CompetitionType type) {
            this.type = type;
            return this;
        }

        public Competition build() {
            Competition competition = new Competition(id, updated, created, name, matches, standings, type);
            return competition;
        }
    }
}
