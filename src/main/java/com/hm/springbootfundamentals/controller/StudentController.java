package com.hm.springbootfundamentals.controller;

import com.hm.springbootfundamentals.model.Student;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private static List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1, "John", "Doe"));
        students.add(new Student(2, "Jane", "Doe"));
    }

    //http://localhost:8080/api/students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    //http://localhost:8080/api/student/1
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //http://localhost:8080/api/student/query?id=1
    @GetMapping("/student/query")
    public Student getStudentQueryById(@RequestParam(name = "id") int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //http://localhost:8080/api/student
    @PostMapping("/student")
    public String addStudent(@RequestBody Student student) {
        students.add(student);
        return "Student added successfully";
    }

    //http://localhost:8080/api/student/1
    @PutMapping("/student/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student student) {
        students.stream()
                .filter(s -> s.getId() == id)
                .forEach(s -> {
                    s.setName(student.getName());
                    s.setCourse(student.getCourse());
                });
        return "Student updated successfully";
    }

    //http://localhost:8080/api/student/1
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {
        students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .ifPresent(s -> students.remove(s));
        return "Student deleted successfully";
    }
}
