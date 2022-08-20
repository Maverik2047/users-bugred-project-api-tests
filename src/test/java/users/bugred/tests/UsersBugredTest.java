package users.bugred.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import users.bugred.models.lombok.*;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static users.bugred.helpers.CustomAllureListener.withCustomTemplates;
import static users.bugred.specs.AddAvatarSpecs.responseAvatar;
import static users.bugred.specs.AddAvatarSpecs.userAvatar;
import static users.bugred.specs.DeleteAvatarSpecs.requestDelete;
import static users.bugred.specs.DeleteAvatarSpecs.responseDelete;
import static users.bugred.specs.DoLoginSpecs.loginRequest;
import static users.bugred.specs.DoLoginSpecs.loginResponse;
import static users.bugred.specs.DoRegisterSpecs.register;
import static users.bugred.specs.DoRegisterSpecs.response;
import static users.bugred.specs.DoUnLoginSpecs.requestLogin;
import static users.bugred.specs.DoUnLoginSpecs.responseLogin;
import static users.bugred.specs.GetUserFullSpecs.userInfo;
import static users.bugred.specs.GetUserFullSpecs.userInfoResponse;


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
                .filter(withCustomTemplates())
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
                .filter(withCustomTemplates())
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
                .filter(withCustomTemplates())
                .spec(requestLogin)
                .body(falseLogin)
                .when()
                .post()
                .then()
                .spec(responseLogin);

    }

    @Test
    @DisplayName("Check if no avatar added test")
    void addAvatar() {
        AddAvatar addAvatar = new AddAvatar();
        addAvatar.setEmail("sammy.breitenberg@example.com");

        AddAvatarResponse avatarResponse = given()
                .filter(withCustomTemplates())
                .spec(userAvatar)
                .body(addAvatar)
                .when()
                .post()
                .then()
                .spec(responseAvatar)
                .extract().as(AddAvatarResponse.class);
        assertThat(avatarResponse.getMessage()).isEqualTo("Параметр avatar является обязательным!");

    }

    @Test
    @DisplayName("Delete avatar test")
    void deleteAvatar() {
        AddAvatar deleteAvatar = new AddAvatar();
        deleteAvatar.setEmail("marylou.cassin@example.com");
        given()
                .filter(withCustomTemplates())
                .spec(requestDelete)
                .body(deleteAvatar)
                .when()
                .post()
                .then()
                .spec(responseDelete);

    }

    @Test
    @DisplayName("Get info about user test")
    void getUserFull() {
        GetUserFull getUser = new GetUserFull();
        getUser.setEmail("marylou.cassin@example.com");
        GetUserFullResponse userResponse = given()
                .filter(withCustomTemplates())
                .spec(userInfo)
                .body(getUser)
                .when()
                .get()
                .then()
                .spec(userInfoResponse)
                .extract().as(GetUserFullResponse.class);
        assertThat(userResponse.getName()).isEqualTo("Muoi McClure II");
        assertThat(userResponse.getAvatar()).isEqualTo("http://users.bugred.ru//tmp/default_avatar.jpg");
        assertThat(userResponse.getEmail()).isEqualTo("marylou.cassin@example.com");
    }
}