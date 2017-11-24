package com.example.demo.learn.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yuj 2017-11-23 21:03
 */
public class Bean {
    private String id;

    private String className;

    private List<Property> properties = new ArrayList<>();

    public String getId() {
        return id;
    }

    public Bean setId(String id) {
        this.id = id;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public Bean setClassName(String className) {
        this.className = className;
        return this;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public Bean setProperties(List<Property> properties) {
        this.properties = properties;
        return this;
    }

    public Bean() {
    }
}
