package uz.pdp.domain.model.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import uz.pdp.domain.model.BaseModel;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseModel {
    private String name;
    @JsonProperty("last_Name")
    private String lastname;
    @JsonFormat(pattern = "[a-zA-Z]\\w+@[a-zA-Z]+\\.com")
    private String email;
    private String password;
    private UserRole role;
}
