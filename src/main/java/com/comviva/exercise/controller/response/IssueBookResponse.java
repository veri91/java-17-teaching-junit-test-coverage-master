package com.comviva.exercise.controller.response;

import java.util.Date;

public record IssueBookResponse(String studentName, String bookName, Date issueDate) {
}
