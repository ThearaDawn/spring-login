package com.springdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by t.daun on 7/17/2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home", "/index"})
    public String home()
    {
        return "index";
    }
}
