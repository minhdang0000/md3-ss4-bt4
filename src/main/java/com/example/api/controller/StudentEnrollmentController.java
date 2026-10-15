package com.example.api.controller;

import com.example.api.model.ApiResponse;
import com.example.api.model.StudentEnrollment;
import com.example.api.service.StudentEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/students-enrollments")
@RequiredArgsConstructor
public class StudentEnrollmentController {
    private final StudentEnrollmentService studentEnrollmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<StudentEnrollment>> enrollStudent(@RequestBody Map<String, Long> requestBody) {
        Long studentId = requestBody.get("studentId");
        Long courseId = requestBody.get("courseId");
        studentEnrollmentService.enrollStudent(studentId, courseId);
        ApiResponse<StudentEnrollment> response = new ApiResponse<>("Student Enrolled Successfully", true, null);
        return ResponseEntity.ok(response);
    }
}
