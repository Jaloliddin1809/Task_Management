package uz.pdp.service.validator;

public abstract class UserValidator {
    public static boolean checkMail(String email){
        if (email==null) return false;
        return email.matches(" /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$/.");
    }
    public static boolean checkPassword(String password){
        if (password.isBlank()) return false;
        return password.matches("/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.[\\W]).{8,}$/");
    }

}
