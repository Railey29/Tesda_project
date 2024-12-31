package com.example;

import java.util.List;
import java.util.Scanner;

import com.example.DataManagment.DataManagmentImplementation;
import com.example.DataManagment.DataManagmentInterface;
import com.example.UserManagment.User;
import com.example.UserManagment.UserImplementation;
import com.example.UserManagment.UserInterface;

public class App {
    public static void main(String[] args) {

        UserInterface user = new UserImplementation();
        List<String> userInput = user.getInputUser(); // methods from the user UserImplementation()
        User users = new User(userInput.get(0), userInput.get(1), userInput.get(2));

        DataManagmentInterface dataManagment = new DataManagmentImplementation();
        dataManagment.AddNotes(users);
    }
}
