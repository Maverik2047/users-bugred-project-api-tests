package users.bugred.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import users.bugred.models.lombok.DoLogin;
import users.bugred.models.lombok.DoRegisterCreate;
import users.bugred.models.lombok.DoUnLogin;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static users.bugred.specs.DoLoginSpecs.loginRequest;
import static users.bugred.specs.DoLoginSpecs.loginResponse;
import static users.bugred.specs.DoRegisterSpecs.register;
import static users.bugred.specs.DoRegisterSpecs.response;
import static users.bugred.specs.DoUnLoginSpecs.requestLogin;
import static users.bugred.specs.DoUnLoginSpecs.responseLogin;


public class UsersBugredTest extends TestBase {
    @Test
    @DisplayName("Register user test")
    void doRegister() {
        DoRegisterCreate registerCreate = new DoRegisterCreate();
        registerCreate.setName(testData.name);
        registerCreate.setEmail(testData.email);
        registerCreate.setPassword(testData.password);
        String expectedEmail = registerCreate.getEmail();


        String actualEmail = given()
                .spec(register)
                .body(registerCreate)
                .when()
                .post()
                .then()
                .spec(response)
                .extract()
                .path("email");
        assertEquals(expectedEmail, actualEmail);


    }

    @Test
    @DisplayName("Successful login user test")
    void trueLoginTest() {
        DoLogin doLogin = new DoLogin();
        doLogin.setEmail("manager@mail.ru");
        doLogin.setPassword("1");
        given()
                .spec(loginRequest)
                .body(doLogin)
                .when()
                .post()
                .then()
                .spec(loginResponse);
        assertThat(doLogin.getEmail()).isEqualTo("manager@mail.ru");


    }

    @Test
    @DisplayName("Unsuccessful login user test")
    void falseLoginTest() {
        DoUnLogin falseLogin = new DoUnLogin();
        falseLogin.setEmail(testData.email);
        falseLogin.setPassword(testData.password);
        given()
                .spec(requestLogin)
                .body(falseLogin)
                .when()
                .post()
                .then()
                .spec(responseLogin);

    }
}