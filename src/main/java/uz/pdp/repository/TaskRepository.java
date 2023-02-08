package uz.pdp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import uz.pdp.domain.model.task.Task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static uz.pdp.util.FileUtils.objectMapper;
import static uz.pdp.util.FileUtils.tasksPath;

public interface TaskRepository{
    File file=new File(tasksPath);
    default ArrayList<Task> getTaskList(){
        try{
            return objectMapper.readValue(file, new TypeReference<ArrayList<Task>>() {
            });
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    default void writeToFile(ArrayList<Task> taskList){
        try {
            objectMapper.writeValue(file,taskList);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}