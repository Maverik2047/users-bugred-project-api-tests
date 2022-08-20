package users.bugred.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class GetUserFullSpecs {
    public static RequestSpecification userInfo = with()
            .basePath("/rest/getuserfull")
            .log().uri()
            .log().body()
            .contentType(JSON);
    public static ResponseSpecification userInfoResponse = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.ALL)
            .build();

}
