package com.example;

import com.example.UserManagment.ChoicesOperation;
import com.example.UserManagment.DisplayChoices;

public class App {

    public static void main(String[] args) {
        DisplayChoices displayChoices = new DisplayChoices();
        int choice = displayChoices.displayChoices();
        ChoicesOperation choiceDashboard = new ChoicesOperation(choice);
        choiceDashboard.executeChoice();

    }
}
