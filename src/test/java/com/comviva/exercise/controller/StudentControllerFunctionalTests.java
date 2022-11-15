package com.comviva.exercise.controller;

import com.comviva.exercise.entiry.Student;
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
public class StudentControllerFunctionalTests extends BaseTest {

    /*
     * Given: Where a student exists in the system
     * When: Call is placed to retrieve the student using student id
     * Then: Details of the student are fetched correctly
     * */

    @Test
    public void getStudentWhenExists_ByStudentId() {
        // test case 1

        // prerequisites
        String msisdn = getRandomNumber();
        String email = "valid@admin.com";
        String name = "Harry";
        Student response = (Student) JsonUtils.getObjectFromJson(
                APICall.addStudent(DefaultData.getAdminRequest(msisdn, email, name)).asString(),
                Student.class);
        Assert.assertEquals("post assert - this will pass", msisdn, response.getMsisdn());

        String studentId = response.getStudentId();
        Student studentFromDatabase = (Student) JsonUtils.getObjectFromJson(APICall.getStudent(studentId).asString(),
                Student.class);

        Assert.assertEquals("get assert", studentFromDatabase.getStudentId(), studentId);

    }


    /*
     * Given: Where a student does not exist in the system
     * When: Call is placed to retrieve the student using student id
     * Then: Exception is thrown
     * */

    @Test
    public void getStudentWhenNotExists_ByStudentId() {
        // test case 2

        String studentId = UUID.randomUUID().toString();
        Response response = APICall.getStudent(studentId);

        Assert.assertEquals("get assert", 500, response.getStatusCode());

    }


}
