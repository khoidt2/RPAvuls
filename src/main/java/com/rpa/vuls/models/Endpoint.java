package com.rpa.vuls.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.io.File;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Endpoint {

    @JsonProperty(value = "endpoint")
    private String endpoint;
    @JsonProperty("describer")
    private String describer;
    @JsonProperty(value = "image")
    private File image;
    @JsonProperty("request")
    private String request;

    public Endpoint setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public Endpoint setDescriber(String describer) {
        this.describer = describer;
        return this;
    }

    public Endpoint setImage(File image) {
        this.image = image;
        return this;
    }

    public Endpoint setRequest(String request) {
        this.request = request;
        return this;
    }
}
