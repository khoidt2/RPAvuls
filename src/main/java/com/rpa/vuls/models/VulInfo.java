package com.rpa.vuls.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VulInfo {

    private String vulnerability;
    private String level;
    private String threat;
    private String how_fix;

}
