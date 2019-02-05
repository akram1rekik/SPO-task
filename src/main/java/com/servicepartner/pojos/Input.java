package com.servicepartner.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"rooms", "senior", "junior"})
public class Input {

    @JsonProperty("rooms")
    private List<Integer> rooms;

    @JsonProperty("senior")
    private int senior;

    @JsonProperty("junior")
    private int junior;

    public List<Integer> getRooms() {
        return rooms;
    }

    public void setRooms(List<Integer> rooms) {
        this.rooms = rooms;
    }

    public Input withRooms(List<Integer> rooms) {
        this.rooms = rooms;
        return this;
    }

    public int getSenior() {
        return senior;
    }

    public void setSenior(int senior) {

        this.senior = senior;
    }

    public Input withDataSenior(int senior) {
        this.senior = senior;
        return this;
    }

    public int getJunior() {
        return junior;
    }

    public void setJunior(int junior) {

        this.junior = junior;
    }

    public Input withDataJunior(int junior) {
        this.junior = junior;
        return this;
    }
}