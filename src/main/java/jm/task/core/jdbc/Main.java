package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Anna", "Annova", (byte) 20);
        userService.saveUser("Lena", "Lenova", (byte) 22);
        userService.saveUser("Sasha", "Sashov", (byte) 24);
        userService.saveUser("Vlad", "Vladov", (byte) 26);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
