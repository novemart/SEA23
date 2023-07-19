package com.example.LibrarySpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class BookController {
    @GetMapping("/book")
    public String getBook(){
        return "myFirstView";
    }
}
