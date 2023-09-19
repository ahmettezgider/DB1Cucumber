package com.guidersoft.config;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Browser {
    private Integer version;
    private List<String> options = new ArrayList<String>();
}
