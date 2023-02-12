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
    public static void main(String[] args){
    }
}