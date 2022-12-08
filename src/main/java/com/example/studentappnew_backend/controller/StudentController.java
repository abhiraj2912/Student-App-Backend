package com.example.studentappnew_backend.controller;

import com.example.studentappnew_backend.dao.StudentDao;
import com.example.studentappnew_backend.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentDao dao;

    @GetMapping("/")
    public  String HomePage(){
        return "Welcome to my website";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/add", consumes="application/json", produces = "application/json")
    public HashMap<String, String> AddStudent(@RequestBody Students s){
        dao.save(s);
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Students> ViewAll(){
        return (List<Students>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/search", consumes="application/json", produces = "application/json")
    List<Students> SearchStudents(@RequestBody Students s){
        String admno =String.valueOf(s.getAdmno());
        System.out.println(admno);
        return (List<Students>) dao.SearchStudents(s.getAdmno());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/delete", consumes="application/json", produces = "application/json")
    public HashMap<String, String>  DeleteStudents(@RequestBody Students s){
        String studentid=String.valueOf(s.getId());
        System.out.println(studentid);
        dao.DeleteStudents(s.getId());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

}
