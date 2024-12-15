package com.example.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    // Dashboard return
    @GetMapping({"","/"})
    public String home() {
        return "redirect:/";

    }

}
