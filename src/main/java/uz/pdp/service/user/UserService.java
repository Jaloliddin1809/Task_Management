package uz.pdp.service.user;

import uz.pdp.domain.dto.response.UserResponse;
import uz.pdp.domain.model.user.User;
import uz.pdp.service.BaseService;

import java.util.ArrayList;

public interface UserService extends BaseService<User, UserResponse> {
    boolean isEmailExists(ArrayList<User> userList, String email);

}
