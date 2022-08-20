package users.bugred.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;


public class DoLoginSpecs {
    public static RequestSpecification loginRequest = with()
            .basePath("/rest/dologin")
            .log().uri()
            .log().body()
            .contentType(JSON);
    public static ResponseSpecification loginResponse =new  ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.ALL)
            .expectBody("result", is(true))
            .build();

}
