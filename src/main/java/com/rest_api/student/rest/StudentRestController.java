package com.rest_api.student.rest;

import com.rest_api.student.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Jeor", "Mormont"));
        theStudents.add(new Student("Rickon", "Stark"));
        theStudents.add(new Student("Daario", "Naharis"));
        theStudents.add(new Student("Margaery", "Tyrell"));
        theStudents.add(new Student("Robert", "Baratheon"));
        theStudents.add(new Student("Davos", "Seaworth"));
        theStudents.add(new Student("Daenerys", "Targaryen"));
        theStudents.add(new Student("Cersei", "Lannister"));
        theStudents.add(new Student("Joffrey", "Baratheon"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }


}
