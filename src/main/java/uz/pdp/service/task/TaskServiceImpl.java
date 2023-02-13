package uz.pdp.service.task;
import uz.pdp.domain.dto.response.TaskResponse;
import uz.pdp.domain.model.task.Task;
import uz.pdp.domain.model.task.TaskStatus;
import uz.pdp.domain.model.task.TaskType;
import uz.pdp.domain.model.user.User;
import uz.pdp.repository.TaskRepository;
import uz.pdp.service.validator.TaskValidator;

import javax.security.auth.Destroyable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;
public class TaskServiceImpl implements TaskService, TaskRepository {
    @Override
    public TaskResponse add(Task task) {
        TaskResponse taskResponse=new TaskResponse();
        ArrayList<Task> taskList=getTaskList();
        int status=0;
        String message="";
        if (isTaskExists(taskList,task)){
            status=200;
            message="Taskni nomi bilan description nomlari unikal bo'lishi kerak";
        }
        else if (TaskValidator.isEmpty(task.getName(),task.getDescription())){
            status=300;
            message="Name yoki tavsif kiritilmagan";
        }
        else{
            status=320;
            message="Task qo'shildi";
            taskList.add(task);
            writeToFileTasks(taskList);
        }
        return taskResponse.setStatus(status).setMessage(message);
    }
    public ArrayList<Task> myCreationTasks(User user){
        ArrayList<Task> tasks=new ArrayList<>();
        ArrayList<Task> taskList=getTaskList();
        for (Task task : taskList) {
            if (user.getId().equals(task.getAssigneeId())){
                tasks.add(task);
            }
        }
        return tasks;
    }
    public ArrayList<Task> myTasks(User user){
        ArrayList<Task> myTasks=new ArrayList<>();
        ArrayList<Task> taskList=getTaskList();
        for (Task task : taskList) {
            if (!task.getStatus().equals(TaskStatus.BLOCKED) && task.getUserId().equals(user.getId())){
                myTasks.add(task);
            }
        }
        return myTasks;
    }
    public TaskResponse updateTask(User user, String taskName,String newTaskDescription,String newTaskName, TaskType tasktype,TaskStatus taskStatus){
        ArrayList<Task> taskList = getTaskList();
        int status=200;
        String message="Qaytadan urinib ko'ring";
        for (Task task : taskList) {
            if (task.getName().equals(taskName)
            && task.getAssigneeId().equals(user.getId())){
                task.setName(newTaskName);
                task.setType(tasktype);
                task.setStatus(taskStatus);
                task.setDescription(newTaskDescription);
                task.setUpdateDate(LocalDateTime.now());
                status=330;
                message="Task yangilandi";
            }
        }
        writeToFileTasks(taskList);
        return new TaskResponse().setMessage(message).setStatus(status);
    }
    public TaskResponse delete(Task task){
        ArrayList<Task> taskList=getTaskList();
        int status=430;
        String message="Qaytadan urinib ko'ring";
        for (Task task1 : taskList) {
            if (task.equals(task1)){
                taskList.remove(task);
                status=230;
                message="Task o'chirildi";
            }
        }
        writeToFileTasks(taskList);
        return new TaskResponse().setStatus(status).setMessage(message);
    }
    @Override
    public Task getById(UUID id) {
        for (Task task : getTaskList()) {
            if (task.getId().equals(id)){
                return task;
            }
        }
        return null;
    }

    @Override
    public Boolean isTaskExists(ArrayList<Task> tasks, Task task) {
        for (Task task1 : tasks) {
            if (task.getName().equals(task1.getName())
            || task.getDescription().equals(task1.getDescription())){
                return true;
            }
        }
        return false;
    }
}
