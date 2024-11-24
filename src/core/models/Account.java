/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import core.models.interfaces.IAccount;

/**
 *
 * @author edangulo
 */
public class Account implements IAccount {

    private final String id;
    private final User owner;
    private double balance;

    public Account(String id, User owner) {
        this.id = id;
        this.owner = owner;
        this.balance = 0;

        this.owner.addAccount(this);
    }

    public Account(String id, User owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;

        this.owner.addAccount(this);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public User getOwner() {
        return owner;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    @Override
    public void setBalance(double value) {
        this.balance = value;
    }

}
