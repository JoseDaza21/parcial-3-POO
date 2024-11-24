/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.interfaces;

import core.models.Account;
import core.models.Transaction;
import core.models.User;

/**
 *
 * @author jose
 */
public interface IStorage extends IUserGetters, IAccountGetters, ITransactionGetters {

    /**
     * Adds a new user to the internal storage
     *
     * @param user user to be added
     * @throws IllegalArgumentException if ID already exists
     */
    void addUser(User user);

    /**
     * Adds a new account to the internal storage
     *
     * @param account account to be added
     */
    void addAccount(Account account);

    /**
     * Adds a new transaction to the internal storage
     *
     * @param transaction transaction to be added
     */
    void addTransaction(Transaction transaction);

    void editBalance(Account account, double value);
}
