package com.example.DataManagment;

import java.util.List;

import com.example.UserManagment.User;

public interface DataManagmentInterface {
    void addNotes(User user);

    void deleteNotes(User user);

    void viewNotes(User user);

    List<User> getNotesList(User user);
}
