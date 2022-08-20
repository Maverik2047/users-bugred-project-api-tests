package users.bugred.models.lombok;


import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserFullResponse {
    String email;
    String name;
    String avatar;
}
