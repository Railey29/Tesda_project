package com.example.UserManagment;

import java.util.Scanner;

public class DisplayChoices {
    Scanner input = new Scanner(System.in);

    public int displayChoices() {
        boolean flag = false;
        int choice = 0;
        while (!flag) {
            System.out.println("----- CHOICES DASHBOARD ------");
            System.out.println("1.AddNots");
            System.out.println("2.DeleteNotes");
            System.out.println("3.ViewNotes");
            System.out.println("4.getNotesList");
            System.out.print("Enter (1-4): ");
            choice = input.nextInt();

            System.out.print("Do you want to try again?(Y/YES): ");
            String tryAgain = input.next();
            clearConsole();
            if (tryAgain.equals("Y") || tryAgain.equals("YES")) {
                flag = true;
            }
        }

        return choice;
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
