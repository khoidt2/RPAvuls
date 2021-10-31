package com.rpa.vuls.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class VulInfo {

    @JsonProperty(value = "vulname")
    private String vulname;
    @JsonProperty("severity")
    private String severity;
    @JsonProperty("thread")
    private String thread;
    @JsonProperty("howfix")
    private String howfix;

    public VulInfo setVulName(String vulname) {
        this.vulname = vulname;
        return this;
    }

    public VulInfo setSeverity(String severity) {
        this.severity = severity;
        return this;
    }

    public VulInfo setThread(String thread) {
        this.thread = thread;
        return this;
    }

    public VulInfo setHowfix(String howfix) {
        this.howfix = howfix;
        return this;
    }
}