package com.rpa.vuls.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Project {

    @JsonProperty(value = "project")
    private String project;
    @JsonProperty(value = "reports")
    private Map<String, Report> reports;

    public Project setProject(String project) {
        this.project = project;
        return this;
    }

    public Project setReports(Map<String, Report> reports) {
        this.reports = reports;
        return this;
    }
}
