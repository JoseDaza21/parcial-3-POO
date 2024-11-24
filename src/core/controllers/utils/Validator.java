/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils;

import core.models.Account;
import core.models.Transaction;
import core.models.User;
import core.models.utils.TransactionType;
import java.util.Random;

/**
 *
 * @author jose
 */
public class Validator {

    // return true if a number (int) is greater or equal than another
    private static boolean fitsRange(int number, int beginning) {
        return number >= beginning;
    }

    // return true if a number (double) is greater or equal than another
    private static boolean fitsRange(double number, double beginning) {
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

    private static int validateUserID(String id) {
        // validate ID
        try {
            int id_int = Integer.parseInt(id);
            if (!Validator.fitsRange(id_int, 0, (int) Math.pow(10, 9) - 1)) {
                throw new IllegalArgumentException("ID must be 0 or more and up to 9 digits long");
            }

            return id_int;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("ID must be numeric");
        }
    }

    // validate the required input in order to create a new user
    public static User validateUserInput(String id, String firstname, String lastname, String age) {
        int id_int = Validator.validateUserID(id);
        int age_int;

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
            if (!Validator.fitsRange(age_int, 18)) {
                throw new IllegalArgumentException("Age must be 18 or more");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Age must be numeric");
        }

        return new User(id_int, firstname, lastname, age_int);
    }

    public static String generateRandomID() {
        Random random = new Random();
        StringBuilder codigo = new StringBuilder();

        // Generate the first 3 digits
        for (int i = 0; i < 3; i++) {
            codigo.append(random.nextInt(10));
        }
        codigo.append('-');

        // Generate the next 6 digits
        for (int i = 0; i < 6; i++) {
            codigo.append(random.nextInt(10));
        }
        codigo.append('-');

        // Generate the last 2 digits
        for (int i = 0; i < 2; i++) {
            codigo.append(random.nextInt(10));
        }

        return codigo.toString();
    }

    public static AccountInput validateAccountInput(String user_id, String initial_balance) {
        int id_int = Validator.validateUserID(user_id);
        double initial_balance_double;

        try {
            initial_balance_double = Double.parseDouble(initial_balance);
            if (!Validator.fitsRange(initial_balance_double, 0)) {
                throw new IllegalArgumentException("Initial balance must be 0 or more");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Initial balance must be float");
        }

        return new AccountInput(id_int, initial_balance_double);
    }

    private static boolean validateAccountFormat(String account_id) {
        String regex = "\\d{3}-\\d{6}-\\d{2}";

        return account_id.matches(regex);
    }

    public static TransactionInput validateTransactionInput(String type, String source_account, String destination_account, String amount) {
        TransactionType transaction_type = TransactionType.DEPOSIT;
        double amount_double;

        switch (type) {
            case "Deposit" ->
                transaction_type = TransactionType.DEPOSIT;

            case "Withdraw" ->
                transaction_type = TransactionType.WITHDRAW;

            case "Transfer" ->
                transaction_type = TransactionType.TRANSFER;
        }

        if ((transaction_type == TransactionType.WITHDRAW || transaction_type == TransactionType.TRANSFER) && !Validator.validateAccountFormat(source_account)) {
            throw new IllegalArgumentException("Source account has an invalid format. Accounts format must be XXX-XXXXXX-XX");
        }

        if ((transaction_type == TransactionType.DEPOSIT || transaction_type == TransactionType.TRANSFER) && !Validator.validateAccountFormat(destination_account)) {
            throw new IllegalArgumentException("Destination account has an invalid format. Accounts format must be XXX-XXXXXX-XX");
        }

        try {
            amount_double = Double.parseDouble(amount);
            if (!Validator.fitsRange(amount_double, 0)) {
                throw new IllegalArgumentException("Amount must be 0 or more");
            }

        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Amount balance must be float");
        }

        return new TransactionInput(transaction_type, source_account, destination_account, amount_double);
    }
}
