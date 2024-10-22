package com.fido.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "JsonRpcRequest")
public class JsonRpcRequest {
    @JsonProperty("jsonrpc")
    private String jsonrpc;

    @Id
    @JsonProperty("id")
    private Long id;

    @JsonProperty("method")
    private String method;

    @ManyToOne
    @JsonProperty("params")
    private Params params;

}
