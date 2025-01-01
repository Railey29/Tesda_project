package com.example.UserManagment;

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

    public void executeChoice() {
        switch (userInput) {
            case 1:
                List<String> userInputAll = userImplemtation.getInputUserAll();
                User user = new User(userInputAll.get(0), userInputAll.get(1), userInputAll.get(2));
                dataManagment.AddNotes(user);
                break;

            case 2:
                List<String> userInputDate = userImplemtation.getInputUserDate();
                User user2 = new User(userInputDate.get(0));
                dataManagment.DeleteNotes(user2);
                break;

            case 3:
                List<String> userInputDate2 = userImplemtation.getInputUserDate();
                User user3 = new User(userInputDate2.get(0));
                dataManagment.ViewNotes(user3);
                break;
            case 4:
                List<String> userInputAll2 = userImplemtation.getInputUserAll();
                User user4 = new User(userInputAll2.get(0), userInputAll2.get(1), userInputAll2.get(2));
                dataManagment.AddNotes(user4);
                break;
        }
    }
}
