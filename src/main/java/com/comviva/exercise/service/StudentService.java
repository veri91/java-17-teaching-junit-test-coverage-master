package com.comviva.exercise.service;

import com.comviva.exercise.controller.request.AddStudentRequest;
import com.comviva.exercise.entiry.Student;

public interface StudentService {
    Student addStudent(AddStudentRequest addStudentRequest);

    Student getStudent(String studentId) throws Exception;
}
