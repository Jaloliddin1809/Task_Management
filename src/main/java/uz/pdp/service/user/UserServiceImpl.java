package uz.pdp.service.user;

import uz.pdp.domain.dto.response.UserResponse;
import uz.pdp.domain.model.task.Task;
import uz.pdp.domain.model.user.User;
import uz.pdp.domain.model.user.UserRole;
import uz.pdp.repository.UserRepository;
import uz.pdp.service.validator.UserValidator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class UserServiceImpl implements UserService, UserRepository {
    @Override
    public UserResponse add(User user) {
        ArrayList<User> userList=getUserList();
        UserResponse userResponse=new UserResponse();
        int status=0;
        String message="";
        String email=user.getEmail();
        String password=user.getPassword();
        String name=user.getName();
        if (!UserValidator.checkPassword(password)){
            status=147;
            message="Siz murakkab parol kiritishingiz kerak\n";
        }
        else if (UserValidator.checkMail(email)) {
            status=231;
            message="Sizning emailingiz namunadagi emailga mos kelmadi\n";
        }
        else if (name.isBlank()){
            status=321;
            message="Name bo'sh\n";
        }
        else if (isEmailExists(getUserList(),email)){
            status=230;
            message="Bu email olden ro'yxatdan o'tkazilgan\n";
        }
        else {
            status = 300;
            message = "Siz muvaffaqqiyatli ro'yxatdan o'tdingiz\n";
            userList.add(user);
            writeToFile(userList);
        }

        userResponse.setStatus(status);
        userResponse.setMessage(message);

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
    public UserResponse signIn(String email,String password){
        ArrayList<User> userList=getUserList();
        UserResponse userResponse=new UserResponse();
        int status=342;
        String message="Parol yoki email xato";
        for (User user : userList) {
            if (user.getEmail().equals(email)
            && user.getPassword().equals(password)){
                status=400;
                message="Xush kelibsiz";
                userResponse.setUserId(user.getId());
            }
        }
        userResponse.setMessage(message);
        userResponse.setStatus(status);
        return userResponse;
    }
    public UserResponse changeUserRole(String userEmail,UserRole userRole){
        ArrayList<User> userList=getUserList();
        UserResponse userResponse=new UserResponse();
        int status=450;
        String message="Bunday emailli user yo'q";
        for (User user : userList) {
            if (user.getEmail().equals(userEmail)){
                status=320;
                message="User role o'zgartirildi";
                user.setRole(userRole);
                user.setUpdateDate(LocalDateTime.now());
            }
        }
        userResponse.setMessage(message);
        userResponse.setStatus(status);
        writeToFile(userList);
        return userResponse;
    }
    public UserResponse delete(String userEmail){
        ArrayList<User> userList=getUserList();
        int status=450;
        String message="Bunday emailli user yo'q";
        for (User user : getUsers()) {
            if (user.getEmail().equals(userEmail)){
                getUserList().remove(user);
                status=330;
                message="User o'chirildi";
            }
        }
        writeToFile(getUserList());
        return new UserResponse().setStatus(status).setMessage(message);
    }
    public ArrayList<User> getUsersByRole(UserRole userRole){
        ArrayList<User> userList=getUserList();
        ArrayList<User> getUsers=new ArrayList<>();
        for (User user:userList){
            if (user.getRole().equals(userRole)){
                getUsers.add(user);
            }
        }
        return getUsers;
    }
    public ArrayList<User> getUsers(){
        return getUserList();
    }
}
