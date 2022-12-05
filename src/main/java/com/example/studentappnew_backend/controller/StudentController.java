package com.example.studentappnew_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/")
    public  String HomePage(){
        return "Welcome to my website";
    }


    @GetMapping("/contact")
    public String ContactPage(){
        return "Welcome to my contact Page";
    }

    @GetMapping("/gallery")
    public String GalleryPage(){
        return "Welcome to my Gallery Page";
    }

    @GetMapping("/home")
    public String Home(){
        return "Welcome to my Home Page";
    }


}
