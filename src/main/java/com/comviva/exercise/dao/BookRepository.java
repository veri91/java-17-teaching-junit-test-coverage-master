package com.comviva.exercise.dao;

import com.comviva.exercise.entiry.Book;
import org.springframework.data.repository.ListCrudRepository;

public interface BookRepository extends ListCrudRepository<Book, String> {
}
