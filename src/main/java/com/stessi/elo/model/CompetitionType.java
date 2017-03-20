package com.stessi.elo.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * @author palmithor
 * @since 8.3.2017.
 */
public class CompetitionType extends BaseModel {

    @SerializedName("name") private final String name;

    public CompetitionType() {
        this.name = null;
    }

    public CompetitionType(final Long id, final Date updated, final Date created, final String name) {
        super(id, updated, created);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Builder create() {
        return new Builder();
    }

    public static final class Builder {
        private Long id;
        private Date updated;
        private Date created;
        private String name;

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

        public CompetitionType build() {
            CompetitionType competitionType = new CompetitionType(id, updated, created, name);
            return competitionType;
        }
    }
}
