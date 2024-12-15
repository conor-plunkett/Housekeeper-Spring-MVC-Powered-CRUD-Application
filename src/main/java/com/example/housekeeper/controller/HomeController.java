package com.example.housekeeper.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    // Dashboard return
    @GetMapping({"","/"})
    public String home() {
        return "redirect:/";

    }

}
