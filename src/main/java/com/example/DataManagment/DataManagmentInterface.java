package com.example.DataManagment;

import java.util.List;

import com.example.UserManagment.User;

public interface DataManagmentInterface {
    void AddNotes(User user);

    void DeleteNotes(User user);

    void ViewNotes(User user);

    List<User> getNotesList(User user);
}
