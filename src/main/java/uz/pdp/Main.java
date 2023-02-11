package uz.pdp;
import uz.pdp.domain.model.task.Task;
import uz.pdp.domain.model.task.TaskStatus;
import uz.pdp.domain.model.task.TaskType;
import uz.pdp.domain.model.user.User;
import uz.pdp.domain.model.user.UserRole;
import uz.pdp.service.task.TaskServiceImpl;
import uz.pdp.service.user.UserServiceImpl;
public class Main{
    static UserServiceImpl userService=new UserServiceImpl();
    static TaskServiceImpl taskService=new TaskServiceImpl();
    public static void main(String[] args) {
        User user=new User("j","b","jvbskbv","vnfjv",UserRole.USER);
        System.out.println(userService.add(user));
        Task task=new Task("Task1","Task",user.getId(),user.getId(),TaskType.SM_TASK,TaskStatus.ASSIGNED);
        System.out.println(taskService.add(task));
        System.out.println(taskService.updateTask(user, "Task", "New", "Task1", TaskType.BE_TASK, TaskStatus.BLOCKED));


    }
}