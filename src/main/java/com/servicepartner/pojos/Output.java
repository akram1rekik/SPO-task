package com.servicepartner.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"senior", "junior"})

public class Output {

    @JsonProperty("senior")
    private int seniorAssociate;

    @JsonProperty("junior")
    private int juniorAssociate;

    public int getSeniorAssociate() {
        return seniorAssociate;
    }

    public void setSeniorAssociate(int seniorAssociate) {
        this.seniorAssociate = seniorAssociate;
    }

    public Output withSeniorAssociate(int seniorAssociate) {
        this.seniorAssociate = seniorAssociate;
        return this;
    }

    public int getJuniorAssociate() {
        return juniorAssociate;
    }

    public void setJuniorAssociate(int juniorAssociate) {
        this.juniorAssociate = juniorAssociate;
    }

    public Output withJuniorAssociate(int juniorAssociate) {
        this.juniorAssociate = juniorAssociate;
        return this;
    }
}
