package com.internship.meetingsmanagement.classes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        User user1 = new User(1, "Raluca", "Martin");
        User user2 = new User(2, "Luiza", "Anghel");
        User user3 = new User(3, "Laura", "Budai");
        User user4 = new User(4, "Raluca", "Prunean");
        User user5 = new User(5, "Eduard", "Hantig");
        User user6 = new User(6, "Petrica", "Timis");
        User user7 = new User(7, "Ioana", "Mihet");
        User user8 = new User(8, "Dorin", "Cret");
        User user9 = new User(9, "Mircea", "Mihet");
        User user10 = new User(10, "Maria", "Mihet");

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
