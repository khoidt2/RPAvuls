package com.rpa.vuls.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Report {

    @JsonProperty(value = "vulInfo")
    private VulInfo vulInfo;
    @JsonProperty(value = "endpoints")
    private List<Endpoint> endpoints;

    public Report setVulInfo(VulInfo vulInfo) {
        this.vulInfo = vulInfo;
        return this;
    }

    public Report setEndpoints(List<Endpoint> endpoints) {
        this.endpoints = endpoints;
        return this;
    }
}
