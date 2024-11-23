/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils;

import core.models.User;

/**
 *
 * @author jose
 */
public class Validator {

    // return true if a number is greater or equal than another
    private static boolean fitsRange(int number, int beginning) {
        return number >= beginning;
    }

    // return true if a number is within a range (inclusive)
    private static boolean fitsRange(int number, int beginning, int end) {
        return number >= beginning && number <= end;
    }

    // check if a string is empty
    private static boolean isEmpty(String s) {
        return s.equals("");
    }

    // validate the required input in order to create a new user
    public static User validateUserInput(String id, String firstname, String lastname, String age) {
        int id_int, age_int;

        // validate ID
        try {
            id_int = Integer.parseInt(id);
            if (!Validator.fitsRange(id_int, 0, (int) Math.pow(10, 9) - 1)) {
                throw new IllegalArgumentException("ID must be 0 or more and up to 9 digits long");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("ID must be numeric");
        }

        // validate Firstname
        if (Validator.isEmpty(firstname)) {
            throw new IllegalArgumentException("First name cannot be empty.");
        }

        // validate Lastname
        if (Validator.isEmpty(lastname)) {
            throw new IllegalArgumentException("Last name cannot be empty.");
        }

        // validate Age
        try {
            age_int = Integer.parseInt(age);
            System.out.println(age_int);
            if (!Validator.fitsRange(age_int, 18)) {
                throw new IllegalArgumentException("Age must be 18 or more");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Age must be numeric");
        }

        return new User(id_int, firstname, lastname, age_int);
    }
}
