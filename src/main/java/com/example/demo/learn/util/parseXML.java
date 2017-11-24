package com.example.demo.learn.util;

import com.example.demo.learn.domain.Bean;
import com.example.demo.learn.domain.Property;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

/**
 * 解析xml文件的信息
 */
public class parseXML {

    public static HashMap analysis() {
        HashMap<String, Bean> hashMap = new HashMap();
        SAXReader reader = new SAXReader();
        try {
            URL resource = parseXML.class.getResource("/");
            System.out.println(resource.getPath());
            InputStream in = parseXML.class.getResourceAsStream("/ioc.xml");
            System.out.println(in);
            Document document = null;
            try {
                document = reader.read(in);
            } catch (DocumentException e) {
                e.printStackTrace();
                throw new RuntimeException("请检查您的xml配置文件路径是否正确！");
            }
            Element rootElement = document.getRootElement();
            System.out.println(rootElement.getName());
            String xPath = "//bean";
            List<Element> list = document.selectNodes(xPath);
            for (Element ele : list) {
                String id = ele.attributeValue("id");
                String aClass = ele.attributeValue("class");
                Bean bean = new Bean();
                bean.setId(id);
                bean.setClassName(aClass);
                List<Element> properties = ele.elements("property");
                for (Element e: properties) {
                    String name = e.attributeValue("name");
                    String value = e.attributeValue("value");
                    Property p = new Property();
                    p.setName(name);
                    p.setValue(value);

                    bean.getProperties().add(p);
                }
                if(hashMap.containsKey(id)) {
                    throw new IllegalArgumentException("存在主键相同的bean");
                }
                hashMap.put(id, bean);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return hashMap;
    }
}
