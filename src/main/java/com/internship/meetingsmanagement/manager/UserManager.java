package com.internship.meetingsmanagement.manager;

import com.internship.meetingsmanagement.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private static List<User> users = new ArrayList<>();

    static {
        setUp();
    }

    public List<User> getUserList() {
        return new ArrayList<>(users);
    }

    public void addUser(User user) {
        users.add(user);
    }

    private static void setUp() {
        users.add(new User(1L, "Raluca", "Martin"));
        users.add(new User(2L, "Luiza", "Anghel"));
        users.add(new User(3L, "Laura", "Budai"));
        users.add(new User(4L, "Raluca", "Prunean"));
        users.add(new User(5L, "Eduard", "Hantig"));
        users.add(new User(6L, "Petrica", "Timis"));
        users.add(new User(7L, "Ioana", "Mihet"));
        users.add(new User(8L, "Dorin", "Cret"));
        users.add(new User(9L, "Mircea", "Mihet"));
        users.add(new User(10L, "Maria", "Mihet"));
    }
}
