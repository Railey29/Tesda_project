package com.example;

import com.example.DataManagment.DataManagmentImplementation;
import com.example.DataManagment.DataManagmentInterface;
import com.example.UserManagment.UserImplementation;
import com.example.UserManagment.UserInterface;

public class App {
    public static void main(String[] args) {
        UserInterface user = new UserImplementation();
        DataManagmentInterface dataManagment = new DataManagmentImplementation();
    }
}
