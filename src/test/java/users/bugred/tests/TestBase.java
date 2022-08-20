package users.bugred.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    TestData testData = new TestData();

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://users.bugred.ru/tasks";
        SelenideLogger.addListener("allure", new AllureSelenide());


    }


}
