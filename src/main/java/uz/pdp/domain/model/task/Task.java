package uz.pdp.domain.model.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.domain.model.BaseModel;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task extends BaseModel {
    private String name;
    private String description;
    private UUID assigneeId;
    private TaskType type;
    private TaskStatus status;
}
