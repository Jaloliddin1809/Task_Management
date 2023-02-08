package uz.pdp.domain.dto.response;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserResponse {
    private UUID userId;
    private int status;
    private String message;
    @Override
    public String toString() {
        return "UserResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
