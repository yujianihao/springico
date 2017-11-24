package com.example.demo.servletContext;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * @author yuj 2017-11-23 10:28
 */
@Service
public class Servlets {

    private HashMap<String, Object> hashMap = new HashMap<>();

    public Object getServlet(String key) {
        if(StringUtils.isEmpty(key)) {
            return null;
        }
        Object object = hashMap.get(key);
        return object;
    }

    public HashMap putServlet(String key, Object obj) {
        if(StringUtils.isEmpty(key) || obj == null) {
            return hashMap;
        }
        if(hashMap.get(key) != null) {
            return hashMap;
        }
        hashMap.put(key, obj);
        return hashMap;
    }
}
