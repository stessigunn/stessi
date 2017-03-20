package com.stessi.elo.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * @author palmithor
 * @since 8.3.2017.
 */
public class Player extends BaseModel {

    @SerializedName("name") private final String name;
    @SerializedName("competitions") private final List<Competition> competitions;


    public Player() {
        this.name = null;
        this.competitions = null;
    }

    public Player(final String name, final List<Competition> competitions) {
        this.name = name;
        this.competitions = competitions;
    }

    public Player(final Long id, final Date updated, final Date created, final String name, final List<Competition> competitions) {
        super(id, updated, created);
        this.name = name;
        this.competitions = competitions;
    }

    public String getName() {
        return name;
    }

    public List<Competition> getCompetitions() {
        return competitions;
    }

    public static Builder create() {
        return new Builder();
    }


    public static final class Builder {
        private Long id;
        private Date updated;
        private Date created;
        private String name;
        private List<Competition> competitions;

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

        public Builder competitions(List<Competition> competitions) {
            this.competitions = competitions;
            return this;
        }

        public Player build() {
            Player player = new Player(id, updated, created, name, competitions);
            return player;
        }
    }
}
