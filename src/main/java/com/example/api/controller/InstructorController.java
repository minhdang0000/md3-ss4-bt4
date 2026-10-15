package com.example.api.controller;

import com.example.api.model.ApiResponse;
import com.example.api.model.Instructor;
import com.example.api.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorRepository instructorRepository;

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> createInstructor(@RequestBody Instructor instructor) {
        instructorRepository.save(instructor);
        ApiResponse<Instructor> response = new ApiResponse<>("Instructor Created Successfully", true, null);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
