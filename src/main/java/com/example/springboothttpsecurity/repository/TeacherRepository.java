package com.example.springboothttpsecurity.repository;

import com.example.springboothttpsecurity.entity.Student;
import com.example.springboothttpsecurity.entity.Teacher;

import java.util.HashMap;

public class TeacherRepository {
    HashMap<String, Teacher> teacherStorage = new HashMap<>();
/*Get the teacher by ID*/
    public Teacher getTeacher(String id){
        return teacherStorage.get(id);
    }
/*Save the data of teacher*/
    public boolean saveTeacher(Teacher teacher){
        String id = teacher.getId();
        if(!teacherStorage.containsKey(id)) {
            teacherStorage.put(id, teacher);
            return true;
        }
        return false;
    }
/*Add student ID to the teacher*/
    public void addStudent(Teacher teacher, Student student){
        String id = teacher.getId();
        teacher.addStudent(student);
        teacherStorage.put(id, teacher);
    }
/*Remove student ID from the teacher*/
    public void removeStudent(Teacher teacher,Student student){
        String id = teacher.getId();
        teacher.removeStudent(student);
        teacherStorage.put(id, teacher);
    }

}
