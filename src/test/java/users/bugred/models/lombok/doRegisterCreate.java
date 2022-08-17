package users.bugred.models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class doRegisterCreate {
    String email;
    String name;
    Integer password;

}
