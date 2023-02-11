package uz.pdp.service.task;
import uz.pdp.domain.dto.response.TaskResponse;
import uz.pdp.domain.model.task.Task;
import uz.pdp.service.BaseService;
import java.util.ArrayList;

public interface TaskService extends BaseService<Task, TaskResponse> {
    Boolean isTaskExists(ArrayList<Task> tasks, Task task);
}
