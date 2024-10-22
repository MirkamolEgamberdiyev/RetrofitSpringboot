package com.fido.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Params")
public class Params {
    @Id
    @JsonProperty("ext_id")
    private String extId;

    @JsonProperty("number")
    private String number;

    @JsonProperty("amount")
    private int amount;

    @JsonProperty("currency")
    private int currency;
}
