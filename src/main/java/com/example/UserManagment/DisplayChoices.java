package com.example.UserManagment;

import java.util.Scanner;

public class DisplayChoices {
    Scanner input = new Scanner(System.in);

    public int displayChoices() {
        System.out.println("1.AddNots");
        System.out.println("2.DeleteNotes");
        System.out.println("3.ViewNotes");
        System.out.println("4.getNotesList");
        System.out.print("Enter a 1-4: ");
        int choice = input.nextInt();
        return choice;
    }
}
