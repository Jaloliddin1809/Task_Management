package uz.pdp.domain.model.task;

import lombok.*;
import uz.pdp.domain.model.BaseModel;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Task extends BaseModel {
    private String name;
    private String description;
    private UUID assigneeId;
    private UUID userId;
    private TaskType type;
    private TaskStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(assigneeId, task.assigneeId) && type == task.type && status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, assigneeId, type, status);
    }

    @Override
    public String toString() {
        return "\n"+"Task{" +"\n"+
                "name='" + name + "\n" +
                "description='" + description + "\n"+
                "type=" + type +"\n"+
                "status=" + status +"\n"+
                "createdDate=" + createdDate +"\n"+
                "updateDate=" + updateDate +"\n"+
                '}'+"\n";
    }
}
