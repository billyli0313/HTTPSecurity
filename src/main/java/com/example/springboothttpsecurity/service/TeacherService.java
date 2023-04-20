package com.example.springboothttpsecurity.service;

import com.example.springboothttpsecurity.entity.Student;
import com.example.springboothttpsecurity.entity.Teacher;
import com.example.springboothttpsecurity.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TeacherService {
    /*Dependency Injection*/
    @Autowired
    private TeacherRepository teacherRepository;
/*Get the teacher by ID*/
    public Teacher getTeacherById(String id){
        return teacherRepository.getTeacher(id);
    }
/*Save the teacher information*/
    public String saveTeacher(Teacher teacher){
        if(teacherRepository.saveTeacher(teacher)){
            return "Successfully created!";
        }
        return teacher.getId() + " already exists!";
    }
/*Add a student ID to the teacher*/
    public void addStudent(Teacher teacher, Student student){
        teacherRepository.addStudent(teacher,student);
    }
    public void removeStudent(Teacher teacher, Student student){
        teacherRepository.removeStudent(teacher,student);
    }
}
