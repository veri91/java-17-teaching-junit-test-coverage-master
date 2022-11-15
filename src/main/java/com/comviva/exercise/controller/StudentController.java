package com.comviva.exercise.controller;

import com.comviva.exercise.controller.request.AddStudentRequest;
import com.comviva.exercise.entiry.Student;
import com.comviva.exercise.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class StudentController {

    private final StudentService studentService;

    @PostMapping(value = "/student",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody AddStudentRequest addStudentRequest) {
        return studentService.addStudent(addStudentRequest);
    }

    @GetMapping(value = "/student/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudentByStudentId(@PathVariable String studentId) throws Exception {
        return studentService.getStudent(studentId);
    }

}
