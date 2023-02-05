package uz.pdp.service.manager;

import uz.pdp.domain.model.user.User;

import java.util.ArrayList;

public interface ManagerService {
    boolean isEmailExists(ArrayList<User> userList, String email);
}
