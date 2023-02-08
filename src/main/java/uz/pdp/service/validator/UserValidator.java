package uz.pdp.service.validator;

import uz.pdp.domain.dto.response.UserResponse;

public abstract class UserValidator {
    public static boolean checkMail(String email){
        if (email==null) return false;
        return email.matches(" /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/.");
    }
    public static Boolean checkPassword(String password){
        int status=0;
        String message="";
        if (password.isBlank()) return false;
        return password.matches("/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.[\\W]).{8,}$/");
    }

}
