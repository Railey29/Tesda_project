package com.example.DataManagment;

import java.util.List;

import com.example.UserManagment.User;

public class DataManagmentImplementation implements DataManagmentInterface {

    @Override
    public List<User> AddNotes(User user) {
        System.out.println("Result: ");
        System.out.println(user.getDateOfNotes());
        System.out.println(user.getTakeNotes());
        System.out.println(user.getTitleNotes());
        return null;
    }

}
