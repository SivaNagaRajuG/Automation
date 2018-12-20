package com.selenium.infrastructure.datahandler;

import java.util.HashMap;
import java.util.Map;

public class DataRecord {

    private Map<String , String> data = new HashMap<String , String>();

    public String get(String field) {
        return data.get(field);
    }

    public void set(String field, String value) {
        this.data.put(field, value);
    }




}
