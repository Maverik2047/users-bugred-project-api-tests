package users.bugred.tests;

import org.junit.jupiter.api.Test;
import users.bugred.models.lombok.doRegisterCreate;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersBugredTest extends TestBase {
    @Test
    void doRegister() {
        doRegisterCreate registerCreate = new doRegisterCreate();
        registerCreate.setName(testData.name);
        registerCreate.setEmail(testData.email);
        registerCreate.setPassword(testData.password);
        String expectedEmail = registerCreate.getEmail();


        String actualEmail = given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(registerCreate)
                .when()
                .post("http://users.bugred.ru/tasks/rest/doregister")
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("email");
        assertEquals(expectedEmail, actualEmail);


    }
}