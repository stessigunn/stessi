package com.stessi.elo.controllers.request;

import com.google.gson.annotations.SerializedName;

/**
 * @author palmithor
 * @since 8.3.2017.
 */
public class CompetitionRequest implements RestRequest {

    @SerializedName("id") private final Long id;
    @SerializedName("name") private final String name;
    @SerializedName("type_id") private final Long typeId;

    public CompetitionRequest() {
        this.id = null;
        this.name = null;
        this.typeId = null;
    }

    public CompetitionRequest(final Long id, final String name, final Long typeId) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getTypeId() {
        return typeId;
    }

    public boolean hasId() {
        return id != null;
    }
}
