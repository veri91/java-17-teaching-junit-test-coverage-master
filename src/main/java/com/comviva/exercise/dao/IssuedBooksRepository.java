package com.comviva.exercise.dao;

import com.comviva.exercise.entiry.IssuedBooks;
import org.springframework.data.repository.ListCrudRepository;

public interface IssuedBooksRepository extends ListCrudRepository<IssuedBooks, String> {
}
