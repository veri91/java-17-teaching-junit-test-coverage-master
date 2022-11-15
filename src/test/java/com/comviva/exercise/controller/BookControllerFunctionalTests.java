package com.comviva.exercise.controller;

import com.comviva.exercise.controller.request.AddBookRequest;
import com.comviva.exercise.controller.request.AddStudentRequest;
import com.comviva.exercise.controller.request.IssueBookRequest;
import com.comviva.exercise.entiry.Book;
import com.comviva.exercise.utils.APICall;
import com.comviva.exercise.utils.BaseTest;
import com.comviva.exercise.utils.DefaultData;
import com.comviva.exercise.utils.JsonUtils;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static com.comviva.exercise.utils.JsonUtils.getRandomNumber;

@RunWith(SpringRunner.class)
public class BookControllerFunctionalTests extends BaseTest {

    /*
     * Given: Where a book exists in the system
     * When: Call is placed to retrieve the book using isbn10
     * Then: Details of the book are fetched correctly
     * */

    @Test
    public void getBookWhenExists_ByISBN10() {
        // test case 3

        // prerequisites
        String bookName = "Alice's Adventures in the Wonderland";
        String ibsn10 = "9789380816715";
        Book response = (Book) JsonUtils.getObjectFromJson(
                APICall.addBook(DefaultData.getBookRequest(bookName, ibsn10)).asString(),
                Book.class);
        Assert.assertEquals("post assert - this will pass", ibsn10, response.getBookId());

        Book fetchResponse = (Book) JsonUtils.getObjectFromJson(
                APICall.getBook(ibsn10).asString(),
                Book.class);

        Assert.assertEquals(ibsn10, fetchResponse.getBookId());

    }


    /*
     * Given: Where a book does not exist in the system
     * When: Call is placed to retrieve the book using ibsn10
     * Then: Exception is thrown
     * */

    @Test
    public void getBookWhenNotExists_ByISBN10() {
        // todo 4 add a test case for the failing scenario

        String ibsn10 ="121121123";
        Response response = APICall.getBook(ibsn10);

        Assert.assertEquals("get assert",500,response.getStatusCode());

    }

    /*
     * Given: Where a book and student exist in the system
     * When: Call is placed to issue a book
     * Then: Book is issued successfully
     * todo 5
     * */

    @Test
    public void  issueBookToStudent(){
        String studentId = UUID.randomUUID().toString();
        String email = "admin@admin.com";
        String msisdn =getRandomNumber();
        AddStudentRequest addStudentRequest = DefaultData.getAdminRequest(msisdn,email,studentId);
        APICall.addStudent(addStudentRequest);

        String bookId = UUID.randomUUID().toString();
        String ibsn10 = getRandomNumber();
        String bookName = "Harry Potter part 1";
        AddBookRequest bookRequest = DefaultData.getBookRequest(ibsn10,bookId);
        APICall.addBook(bookRequest);

        //When
        IssueBookRequest issueBookRequest = DefaultData.getIssueBookRequest(
                addStudentRequest.getStudentId(),
                //
                bookId

        );

        Response response = APICall.addBook(new AddBookRequest(bookId,bookName))

        Assert.assertEquals(200,response.getStatusCode());

    }

    /*
     * Given: Where a book and student exist in the system
     * When: Call is placed to issue a book to two students
     * Then: Book issued to the first student but fails for the second
     * todo 6
     * */

    @Test
    public void issueBook(){

    }





}
