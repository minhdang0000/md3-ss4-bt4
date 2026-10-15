package com.example.api.service;

import com.example.api.model.Course;
import com.example.api.model.Instructor;
import com.example.api.repository.CourseRepository;
import com.example.api.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;

    public void createCourse(Course course) {
        if (course.getInstructor() != null && course.getInstructor().getId() != null) {
            Instructor instructor = instructorRepository.findById(course.getInstructor().getId())
                    .orElseThrow(() -> new RuntimeException("Instructor not found"));
            course.setInstructor(instructor);
        }
        courseRepository.save(course);
    }

    public void updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setTitle(courseDetails.getTitle());
        course.setStatus(courseDetails.getStatus());
        if (courseDetails.getInstructor() != null && courseDetails.getInstructor().getId() != null) {
            Instructor instructor = instructorRepository.findById(courseDetails.getInstructor().getId())
                    .orElseThrow(() -> new RuntimeException("Instructor not found"));
            course.setInstructor(instructor);
        }
        courseRepository.save(course);
    }
}
