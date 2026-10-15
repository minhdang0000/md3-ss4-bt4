package com.example.api.repository;

import com.example.api.model.Instructor;
import com.example.api.model.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollment,Long> {

}
