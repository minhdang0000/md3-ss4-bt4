package com.example.api.service;

import com.example.api.model.Course;
import com.example.api.model.Student;
import com.example.api.model.StudentEnrollment;
import com.example.api.repository.CourseRepository;
import com.example.api.repository.StudentEnrollmentRepository;
import com.example.api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentEnrollmentService {
    private final StudentEnrollmentRepository studentEnrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public void enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        StudentEnrollment enrollment = new StudentEnrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        studentEnrollmentRepository.save(enrollment);
    }
}
