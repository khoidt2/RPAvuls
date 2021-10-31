package com.rpa.vuls.proccess;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rpa.vuls.models.Project;

public class JsonBuilder {

    public JsonBuilder() {}

    public String encode(Project project) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(project);
        return json;
    }

    public void decode(String json) {

    }
}
