package com.comviva.exercise.service;

import com.comviva.exercise.controller.request.AddBookRequest;
import com.comviva.exercise.controller.request.IssueBookRequest;
import com.comviva.exercise.controller.response.IssueBookResponse;
import com.comviva.exercise.dao.BookRepository;
import com.comviva.exercise.dao.IssuedBooksRepository;
import com.comviva.exercise.dao.StudentRepository;
import com.comviva.exercise.entiry.Book;
import com.comviva.exercise.entiry.IssuedBooks;
import com.comviva.exercise.entiry.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final StudentRepository studentRepository;

    private final IssuedBooksRepository issuedBooksRepository;

    @Override
    public Book addBookToLibrary(AddBookRequest addBookRequest) {
        return bookRepository.save(getBookEntity(addBookRequest));
    }

    private Book getBookEntity(AddBookRequest addBookRequest) {
        return new Book(addBookRequest.isbn10(), addBookRequest.bookName());
    }

    @Override
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @Override
    public IssueBookResponse issueBook(IssueBookRequest issueBookRequest) throws Exception {

        Student student = studentRepository.findById(issueBookRequest.StudentId())
                .orElseThrow(() -> new Exception("Student not found"));

        Book book = bookRepository.findById(issueBookRequest.bookCode())
                .orElseThrow(() -> new Exception("Book not found"));

        Date issueDate = new Date();

        issuedBooksRepository.save(issueBookEntity(student, book, issueDate));

        return new IssueBookResponse(student.getStudentName(), book.getBookName(), issueDate);
    }

    @Override
    public Book getBookDetails(String bookId) throws Exception {
        return bookRepository.findById(bookId).orElseThrow(() -> new Exception("book not found"));
    }

    public IssuedBooks issueBookEntity(Student student, Book book, Date issueDate) {
        return new IssuedBooks(
                UUID.randomUUID().toString(),
                student, book, issueDate);
    }
}
