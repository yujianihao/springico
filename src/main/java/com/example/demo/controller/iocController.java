package com.example.demo.controller;

import com.example.demo.learn.util.InitServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前端调用的接口
 * @author yuj 2017-11-23 10:34
 */
@RestController
@RequestMapping(value = "/ioc")
public class iocController {

    @Autowired
    private InitServlet InitServlet;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        InitServlet.createBeans();
        Object person = InitServlet.getBean("Person");

        return person.toString();
    }
}
