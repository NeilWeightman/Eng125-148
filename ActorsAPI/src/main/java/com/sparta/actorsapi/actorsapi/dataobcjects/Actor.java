package com.sparta.actorsapi.actorsapi.dataobcjects;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class Actor {


    private int actorId;

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    // @JsonProperty("Name of Actor")
    private String firstName;
    private String lastname;
    private Date lastUpdate;

    public Actor(int actorId, String firstName, String lastname, Date lastUpdate) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastname = lastname;
        this.lastUpdate = lastUpdate;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


}
