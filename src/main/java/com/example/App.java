package com.example;

import java.util.Scanner;

import com.example.UserManagment.ChoicesOperation;
import com.example.UserManagment.DisplayChoices;

public class App {
    private final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        DisplayChoices displayChoices = new DisplayChoices();
        int choice = displayChoices.displayChoices();
        ChoicesOperation choiceDashboard = new ChoicesOperation(choice);
        choiceDashboard.executeChoice();
    }
}
