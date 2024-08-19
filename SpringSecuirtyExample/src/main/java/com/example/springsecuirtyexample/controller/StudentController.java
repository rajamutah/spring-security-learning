package com.example.springsecuirtyexample.controller;

import com.example.springsecuirtyexample.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    public List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Meena",100),
            new Student(2,"Raja",99),
            new Student(3,"Amutha",100),
            new Student(4,"Sangavi",100)
    ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/csrf_token")
    public CsrfToken csrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student create(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
