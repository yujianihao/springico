package com.example.demo.learn.util;

import com.example.demo.learn.domain.Bean;
import com.example.demo.learn.domain.Property;
import com.example.demo.util.BeanUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author yuj 2017-11-23 21:40
 */
@Component
public class InitServlet {

    private HashMap<String, Object> hashMap = new HashMap();

    public void createBeans() {
        HashMap<String, Bean> beanMap = parseXML.analysis();
        Set<String> set = beanMap.keySet();
        for (String id : set) {
            Bean bean = beanMap.get(id);
            Object bean1 = createBean(bean);
            if(!hashMap.containsKey(id) && bean1 != null) {
                hashMap.put(id, bean1);
            }
        }
    }

    public Object createBean(Bean bean) {
        String className = bean.getClassName();
        Class aClass = null;
        Object obj = null;
        try {
            aClass = Class.forName(className);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            obj = aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        List<Property> properties = bean.getProperties();
        for (Property p: properties) {
            String name = p.getName();
            Method setMethod = BeanUtil.getSetMethod(obj, name);
            if(setMethod  != null) {
                try {
                    setMethod.invoke(obj, p.getValue());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }

    public Object getBean(String name) {
        if(StringUtils.isEmpty(name)) {
            return null;
        }
        Object o = hashMap.get(name);
        return o;
    }
}
