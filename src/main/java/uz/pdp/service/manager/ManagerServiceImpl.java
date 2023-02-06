package uz.pdp.service.manager;

import uz.pdp.domain.model.user.User;
import uz.pdp.domain.model.user.UserRole;
import uz.pdp.service.BaseService;

import java.util.ArrayList;
import java.util.UUID;

public class ManagerServiceImpl implements ManagerService{

    @Override
    public boolean selectUserRole(ArrayList<User> users, User user, UserRole userRole) {
        return false;
    }
}
