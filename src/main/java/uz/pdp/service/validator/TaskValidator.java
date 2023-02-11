package uz.pdp.service.validator;

import java.util.function.BinaryOperator;

public class TaskValidator {
    public static Boolean isEmpty(String taskName,String taskDescription){
        return taskName.isBlank() || taskDescription.isBlank();
    }

}
