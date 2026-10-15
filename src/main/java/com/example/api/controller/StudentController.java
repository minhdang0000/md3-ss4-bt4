package com.example.api.controller;

import com.example.api.model.ApiResponse;
import com.example.api.model.Student;
import com.example.api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody Student student) {
        studentRepository.save(student);
        ApiResponse<Student> response = new ApiResponse<>("Student Created Successfully", true, null);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
