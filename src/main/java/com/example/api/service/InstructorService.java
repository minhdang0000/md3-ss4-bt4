package com.example.api.service;

import com.example.api.model.Instructor;
import com.example.api.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {
    private final InstructorRepository instructorRepository;
    public Instructor findInstructorById(Long id){
        return instructorRepository.findById(id).orElseThrow(()-> new RuntimeException("Instructor not found"));
    }
    public List<Instructor> findAllInstructors(){
        return instructorRepository.findAll();
    }
    public Instructor createInstructor(Instructor instructor){
        return instructorRepository.save(instructor);
    }
}
