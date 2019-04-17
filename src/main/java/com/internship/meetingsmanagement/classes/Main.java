package com.internship.meetingsmanagement.classes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User user1 = new User(1L, "Raluca", "Martin");
        User user2 = new User(2L, "Luiza", "Anghel");
        User user3 = new User(3L, "Laura", "Budai");
        User user4 = new User(4L, "Raluca", "Prunean");
        User user5 = new User(5L, "Eduard", "Hantig");
        User user6 = new User(6L, "Petrica", "Timis");
        User user7 = new User(7L, "Ioana", "Mihet");
        User user8 = new User(8L, "Dorin", "Cret");
        User user9 = new User(9L, "Mircea", "Mihet");
        User user10 = new User(10L, "Maria", "Mihet");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);
        userList.add(user8);
        userList.add(user9);
        userList.add(user10);

    }
}
