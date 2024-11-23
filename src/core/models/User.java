/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import core.models.interfaces.IUser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edangulo
 */
public class User implements IUser {

    private final int id;
    private final String firstname;
    private final String lastname;
    private final int age;
    private final List<Account> accounts;

    /**
     * Instance a new user
     * @param id user id
     * @param firstname user first name
     * @param lastname user last name
     * @param age user age
     */
    public User(int id, String firstname, String lastname, int age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.accounts = new ArrayList<>();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFirstname() {
        return firstname;
    }

    @Override
    public String getLastname() {
        return lastname;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getNumAccounts() {
        return this.accounts.size();
    }

    @Override
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

}
