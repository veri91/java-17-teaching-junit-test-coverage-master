package com.comviva.exercise.utils;


import com.comviva.exercise.controller.request.AddBookRequest;
import com.comviva.exercise.controller.request.AddStudentRequest;
import com.comviva.exercise.controller.request.IssueBookRequest;
import com.comviva.exercise.entiry.IssuedBooks;

import java.time.LocalDateTime;


public class DefaultData {

    public static AddStudentRequest getAdminRequest(String msisdn, String email, String name) {
        return new AddStudentRequest(name, msisdn, email);
    }

    public static AddBookRequest getBookRequest(String bookName, String isbn10) {
        return new AddBookRequest(bookName, isbn10);
    }


    public static IssueBookRequest getIssueBookRequest(String bookId,String studentId){
        return new IssueBookRequest( bookId,studentId);
    }
}

