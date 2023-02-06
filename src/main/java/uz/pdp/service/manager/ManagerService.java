package uz.pdp.service.manager;

import uz.pdp.domain.model.user.User;
import uz.pdp.domain.model.user.UserRole;

import java.util.ArrayList;

public interface ManagerService {
     boolean selectUserRole(ArrayList<User> users,User user,UserRole userRole);
}
