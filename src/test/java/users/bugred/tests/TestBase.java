package users.bugred.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    TestData testData = new TestData();

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://users.bugred.ru/tasks";

    }
}
