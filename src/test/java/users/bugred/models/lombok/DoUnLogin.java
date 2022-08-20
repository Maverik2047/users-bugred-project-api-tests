package users.bugred.models.lombok;

import io.restassured.specification.RequestSpecification;
import lombok.Data;

@Data
public class DoUnLogin  {
    String email;
    String password;

}
