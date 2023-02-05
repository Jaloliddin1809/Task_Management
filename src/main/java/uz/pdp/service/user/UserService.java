package uz.pdp.service.user;

import uz.pdp.domain.model.user.User;
import uz.pdp.service.BaseService;

import java.util.ArrayList;

public interface UserService extends BaseService<User> {
    boolean isEmailExists(ArrayList<User> userList, String email);

}
