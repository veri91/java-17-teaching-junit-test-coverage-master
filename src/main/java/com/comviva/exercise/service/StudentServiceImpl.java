package com.comviva.exercise.service;

import com.comviva.exercise.controller.request.AddStudentRequest;
import com.comviva.exercise.dao.StudentRepository;
import com.comviva.exercise.entiry.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student addStudent(AddStudentRequest addStudentRequest) {
        return studentRepository.save(getStudentEntity(addStudentRequest));
    }

    @Override
    public Student getStudent(String studentId) throws Exception {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new Exception("student not found"));
    }

    private Student getStudentEntity(AddStudentRequest addStudentRequest) {
        return new Student(
                UUID.randomUUID().toString(),
                addStudentRequest.name(),
                addStudentRequest.msisdn(),
                addStudentRequest.email()
        );
    }
}
