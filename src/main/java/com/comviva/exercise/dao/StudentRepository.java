package com.comviva.exercise.dao;

import com.comviva.exercise.entiry.Student;
import org.springframework.data.repository.ListCrudRepository;

public interface StudentRepository extends ListCrudRepository<Student, String> {
}
