package com.example.UserManagment;

import java.util.ArrayList;
import java.util.List;

import com.example.DataManagment.DataManagmentImplementation;
import com.example.DataManagment.DataManagmentInterface;
import com.example.UserManagment.User;
import com.example.UserManagment.UserImplementation;
import com.example.UserManagment.UserInterface;

public class ChoicesOperation {
    private int userInput;

    private UserInterface userImplemtation = new UserImplementation();
    private DataManagmentInterface dataManagment = new DataManagmentImplementation();

    public ChoicesOperation(int userInput) {
        this.userInput = userInput;
    }

    private User createUserWithDateInput() {
        List<String> userInputDate = userImplemtation.getInputUserDate();
        return new User(userInputDate.get(0));
    }

    private User createWithAllData() {
        List<String> userInputAll = userImplemtation.getInputUserAll();
        return new User(userInputAll.get(0), userInputAll.get(1), userInputAll.get(2));
    }

    private void insert() {
        System.out.println("----------------------------------------------------------------");
        User user = createWithAllData();
        dataManagment.addNotes(user);
    }

    private void delete() {
        System.out.println("----------------------------------------------------------------");
        User user = createUserWithDateInput();
        dataManagment.deleteNotes(user);
    }

    private void view() {
        System.out.println("----------------------------------------------------------------");
        User user = createUserWithDateInput();
        dataManagment.viewNotes(user);
    }

    private void getAllNotes() {
        System.out.println("----------------------------------------------------------------");
        System.out.println("--- LIST OF ALL NOTES ----");
        System.out.println("----------------------------------------------------------------");

        List<User> usersNotes = dataManagment.getNotesList(null);

        for (User user : usersNotes) {
            System.out.println("DATE: " + user.getDateOfNotes());
            System.out.println("TITLE: " + user.getTitleNotes());
            System.out.println("NOTES: " + user.getTakeNotes());
            System.out.println("----------");
        }
    }

    public void executeChoice() {
        switch (userInput) {
            case 1:
                insert();
                break;

            case 2:
                delete();
                break;

            case 3:
                view();
                break;
            case 4:
                getAllNotes();
                break;
        }
    }
}
