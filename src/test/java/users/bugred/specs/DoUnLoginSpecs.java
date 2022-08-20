package users.bugred.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;


public class DoUnLoginSpecs {
    public static RequestSpecification requestLogin = with()
            .basePath("/tasks/rest/dologin")
            .log().uri()
            .log().all()
            .contentType(JSON);
    public static ResponseSpecification responseLogin = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.ALL)
            .expectBody("result", is(false))
            .build();

}
