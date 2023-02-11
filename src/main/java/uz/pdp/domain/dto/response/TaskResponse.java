package uz.pdp.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class TaskResponse {
    private UUID taskId;
    private Integer status;
    private String message;
    @Override
    public String toString() {
        return "TaskResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
