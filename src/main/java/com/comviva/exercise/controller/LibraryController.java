package com.comviva.exercise.controller;

import com.comviva.exercise.controller.request.AddBookRequest;
import com.comviva.exercise.controller.request.IssueBookRequest;
import com.comviva.exercise.controller.response.IssueBookResponse;
import com.comviva.exercise.entiry.Book;
import com.comviva.exercise.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class LibraryController {

    private final BookService bookService;

    @PostMapping(value = "/book",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Book addBookToLibrary(@RequestBody AddBookRequest addBookRequest) {
        return bookService.addBookToLibrary(addBookRequest);
    }

    @GetMapping(value = "/book",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBookList() {
        return bookService.getBookList();
    }

    @GetMapping(value = "/book/{bookId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Book getBookDetails(@PathVariable String bookId) throws Exception {
        return bookService.getBookDetails(bookId);
    }

    @GetMapping(value = "/book/issue", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public IssueBookResponse issueBook(@RequestBody IssueBookRequest issueBookRequest) throws Exception {
        return bookService.issueBook(issueBookRequest);
    }

}
