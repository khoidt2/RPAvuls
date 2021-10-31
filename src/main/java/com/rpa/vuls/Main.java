package com.rpa.vuls;

import com.rpa.vuls.models.Project;
import com.rpa.vuls.proccess.GenDoc;

public class Main {

    public static void main(String[] args) throws Exception {
        Project project = new Project();
        GenDoc genDocx = new GenDoc();
        genDocx.proccess(project);
    }
}
