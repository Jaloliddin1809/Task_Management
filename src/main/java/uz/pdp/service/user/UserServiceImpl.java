package uz.pdp.service.user;

import uz.pdp.domain.dto.response.UserResponse;
import uz.pdp.domain.model.user.User;
import uz.pdp.repository.UserRepository;
import uz.pdp.service.validator.UserValidator;

import java.util.ArrayList;
import java.util.UUID;

public class UserServiceImpl implements UserService, UserRepository {
    @Override
    public UserResponse SignUp(User user) {
        UserResponse userResponse=new UserResponse();
        int status=0;
        String message="";
        String email=user.getEmail();
        String password=user.getPassword();
        String name=user.getName();
        if (!UserValidator.checkPassword(password)){
            status=100;
            message="Siz murakkab parol kiritishingiz kerak\n";
        }
        if (UserValidator.checkMail(email)) {
            status=200;
            message="Sizning emailingiz namunadagi emailga mos kelmadi";
        }
        if (name.isBlank()){
            status=300;
            message="Name bo'sh";
        }
        if (isEmailExists())
        return userResponse;
    }

    @Override
    public User getById(UUID id) {
        for (User user : getUserList()) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean isEmailExists(ArrayList<User> userList, String email) {
        for (User user:userList) {
            if(user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    public UserResponse signUp(String email,String password){
    }
}
