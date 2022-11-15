package com.comviva.exercise.service;

import com.comviva.exercise.controller.request.AddBookRequest;
import com.comviva.exercise.controller.request.IssueBookRequest;
import com.comviva.exercise.controller.response.IssueBookResponse;
import com.comviva.exercise.entiry.Book;
import com.comviva.exercise.entiry.Student;

import java.util.List;

public interface BookService {
    Book addBookToLibrary(AddBookRequest addBookRequest);

    List<Book> getBookList();

    IssueBookResponse issueBook(IssueBookRequest issueBookRequest) throws Exception;

    Book getBookDetails(String bookId) throws Exception;
}
