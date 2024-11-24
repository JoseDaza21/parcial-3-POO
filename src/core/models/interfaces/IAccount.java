/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.interfaces;

import core.models.User;

/**
 *
 * @author jose
 */
public interface IAccount {

    /**
     * Getter for the account id
     *
     * @return account id
     */
    String getId();

    /**
     * Getter for the account owner
     *
     * @return account owner
     */
    User getOwner();

    /**
     * Getter for the account balance
     *
     * @return account balance
     */
    double getBalance();

    /**
     * Deposits an amount
     *
     * @param amount
     */
    void deposit(double amount);

    /**
     * Make a withdraw
     *
     * @param amount amount of money
     * @return withdraw operation status
     */
    boolean withdraw(double amount);

    /**
     * Setter for the account balance
     *
     * @param value account balance
     */
    void setBalance(double value);
}
