package uz.pdp;

import uz.pdp.domain.model.user.Manager;
import uz.pdp.service.user.UserService;
import uz.pdp.service.user.UserServiceImpl;

public class Main {
    static UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
        Manager manager = new Manager();
        System.out.println("manager.getName() = " + manager.getName());
        System.out.println("manager.getId() = " + manager.getId());
    }
}