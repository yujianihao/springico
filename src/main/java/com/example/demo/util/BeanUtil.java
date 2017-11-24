package com.example.demo.util;

import java.lang.reflect.Method;

/**
 * @author yuj 2017-11-23 22:02
 */
public class BeanUtil {

    public static Method getSetMethod(Object obj, String name) {
        if(name == null || obj == null) {
            return null;
        }
        Method  met = null;
        String setName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
        Method[] methods = obj.getClass().getMethods();
        for (Method method : methods) {
            if(method.getName().equals(setName)) {
                met = method;
                break;
            }
        }
        return met;
    }


    public static Method getGetMethod(Object obj, String name) {
        if(name == null || obj == null) {
            return null;
        }
        Method met = null;
        String getName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
        Method[] methods = obj.getClass().getMethods();
        for (Method method : methods) {
            if(method.getName().equals(getName)) {
                met = method;
                break;
            }
        }
        return met;
    }
}
