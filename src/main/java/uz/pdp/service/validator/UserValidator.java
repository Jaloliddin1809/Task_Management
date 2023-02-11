package uz.pdp.service.validator;

import uz.pdp.domain.dto.response.UserResponse;

public class UserValidator {
    public static boolean checkMail(String email){
        if (email==null) return false;
        return email.matches(" /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/.");
    }
    public static Boolean checkPassword(String password){

            return !password.isBlank();
//        return password.matches("[A-Za-z\\d@$!%*?&] ");
    }

}
