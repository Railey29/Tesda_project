package com.example.DataManagment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.UserManagment.User;

public class DataManagmentImplementation implements DataManagmentInterface {
    private final String URL = "jdbc:mysql://localhost:3306/takingnotes_db";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    private Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private boolean CheckerDate(String date) {
        boolean result = false;

        String query = "SELECT set_date FROM notes_method WHERE set_date = ?";
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = true;
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void addNotes(User user) {
        String query = "INSERT INTO notes_method (add_notes , set_date , title_notes) VALUES (? , ? , ?)";

        boolean flag = CheckerDate(user.getDateOfNotes());

        if (flag) {
            throw new IllegalArgumentException("This Date is have a Notes");
        }

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, user.getTakeNotes());
            preparedStatement.setString(2, user.getDateOfNotes());
            preparedStatement.setString(3, user.getTitleNotes());

            int rowsInterseted = preparedStatement.executeUpdate();
            if (rowsInterseted > 0) {
                System.out.println("---- INSERTED SUCCESSFULLY ----");
            } else {
                System.out.println("---- INSERTED FAILED ----");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteNotes(User user) {
        String query = "DELETE FROM notes_method WHERE set_date = ?";

        boolean flag = CheckerDate(user.getDateOfNotes());

        if (!flag) {
            throw new IllegalArgumentException("This is Empty");
        }

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, user.getDateOfNotes());

            int rowsInterseted = preparedStatement.executeUpdate();
            if (rowsInterseted > 0) {
                System.out.println("---- DELETED SUCCESSFULLY ----");
            } else {
                System.out.println("---- DELETED FAILED ----");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewNotes(User user) {
        String query = "SELECT set_date , title_notes , add_notes FROM notes_method WHERE set_date = ?";
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);) {
            preparedStatement.setString(1, user.getDateOfNotes());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("---- VIEW RESULT ----");
                String date = resultSet.getNString("set_date");
                String title = resultSet.getNString("title_notes");
                String notes = resultSet.getNString("add_notes");

                System.out.println("Date: " + date);
                System.out.println("Title: " + title);
                System.out.println("Notes: " + notes);
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getNotesList(User user) {
        List<User> notesList = new ArrayList<User>();
        String query = "SELECT * FROM notes_method";
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                User note = new User(resultSet.getString("set_date"),
                        resultSet.getString("title_notes"),
                        resultSet.getString("add_notes"));
                notesList.add(note);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return notesList;
    }

}
