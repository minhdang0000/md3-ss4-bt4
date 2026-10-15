package com.example.api.controller;

import com.example.api.model.ApiResponse;
import com.example.api.model.Course;
import com.example.api.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> createCourse(@RequestBody Course course) {
        courseService.createCourse(course);
        ApiResponse<Course> response = new ApiResponse<>("Course Created Successfully", true, null);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        courseService.updateCourse(id, course);
        ApiResponse<Course> response = new ApiResponse<>("Course Updated Successfully", true, null);
        return ResponseEntity.ok(response);
    }
}
