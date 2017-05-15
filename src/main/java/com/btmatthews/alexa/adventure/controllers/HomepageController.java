package com.btmatthews.alexa.adventure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomepageController {

    @RequestMapping("/")
    public String showDefaultPage() {
        return showPage("index");
    }

    @RequestMapping("/{page}.html")
    public String showPage(@PathVariable("page") final String page) {
        return page;
    }
}
