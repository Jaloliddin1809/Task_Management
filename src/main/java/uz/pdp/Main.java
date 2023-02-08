package uz.pdp;

import uz.pdp.domain.dto.response.UserResponse;
import uz.pdp.domain.model.user.User;
import uz.pdp.domain.model.user.UserRole;
import uz.pdp.service.user.UserServiceImpl;

import java.io.PushbackReader;

public class Main{
    static UserServiceImpl userService=new UserServiceImpl();
    public static void main(String[] args){
        UserResponse userResponse = userService.signUp(new User("", "jhnfjvn", "rfrgrh", "ghrgvf", UserRole.USER));
        System.out.println("userResponse = " + userResponse);
    }
}