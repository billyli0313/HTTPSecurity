package com.example.springboothttpsecurity.controller;

import com.example.springboothttpsecurity.entity.Teacher;
import com.example.springboothttpsecurity.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
/*Dependency Injection*/
    @Autowired
    private TeacherService service ;
/*Create a new teacher*/
    @PostMapping(value = "/create/teacher")
    public String createTeacher(@RequestBody Teacher teacher){

        return service.saveTeacher(teacher);
    }
/*Show the teacher by ID*/
    @GetMapping(value = "/teacher")
    @ResponseBody
    public Teacher getTeacher(@RequestParam(value = "id")String id){
        return service.getTeacherById(id);
    }

}
