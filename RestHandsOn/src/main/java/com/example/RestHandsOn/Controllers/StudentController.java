package com.example.RestHandsOn.Controllers;

import com.example.RestHandsOn.Models.Response;
import com.example.RestHandsOn.Models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/students")
public class StudentController {

    private List<Student> studentDetails;
    private static int id = 0;

    public StudentController() {
        studentDetails = new ArrayList<>();
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getStudentInfo() {
        if( studentDetails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(studentDetails, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Student> createStudentInfo(@RequestBody Student student) {
        student.setId(++id);
        this.studentDetails.add(student);
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Student> updateStudentDetails(@RequestBody Student student) {
        if(!studentDetails.contains(student)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        int index = this.studentDetails.indexOf(student);
        studentDetails.set(index, student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudentDetail(@PathVariable("id") Integer id) {
        System.out.println("id == " + id);
        Student student = new Student(id);

        if(!studentDetails.contains(student)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        studentDetails.remove(student);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
