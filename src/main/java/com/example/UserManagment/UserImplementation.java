package com.example.UserManagment;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserImplementation implements UserInterface {

    @Override
    public List<String> getInputUser() {
        Scanner input = new Scanner(System.in);
        String date = "";
        String title = "";
        String content = "";

        try {
            while (true) {
                System.out.print("Enter Date of Notes (YYYY-MM-DD): ");
                date = input.nextLine();
                if (isValidDate(date)) {
                    break;
                } else {
                    System.out.println("Invalid date. Please enter a valid date in YYYY-MM-DD format.");
                }
            }

            System.out.print("Enter a Title of Your Notes: ");
            title = input.nextLine();
            System.out.print("Enter Content of your Notes: ");
            content = input.nextLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
        input.close();

        List<String> userInput = new ArrayList<>();
        userInput.add(date);
        userInput.add(title);
        userInput.add(content);

        return userInput;
    }

    // this is for checker if valid the date format
    private boolean isValidDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
