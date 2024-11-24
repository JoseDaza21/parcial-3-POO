/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storage;

import core.controllers.utils.ElementNotFoundException;
import core.models.Account;
import core.models.Transaction;
import core.models.User;
import core.models.interfaces.IStorage;
import core.models.interfaces.IStorageValidator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose
 */
public class Storage implements IStorage {

    private final List<User> users;
    private final List<Account> accounts;
    private final List<Transaction> transactions;
    private final IStorageValidator storageValidator;

    /**
     * Instance the storage
     *
     * @param storageValidator validator used for data
     */
    public Storage(IStorageValidator storageValidator) {
        this.users = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.transactions = new ArrayList<>();

        this.storageValidator = storageValidator;
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(this.users); // returns a copy
    }

    @Override
    public User getUser(int user_id) {
        for (User u : this.users) {
            if (u.getId() == user_id) {
                return u;
            }
        }

        throw new ElementNotFoundException("User with ID " + user_id + " not found");
    }

    @Override
    public void addUser(User user) {
        //TODO: VALIDAR ESTO CON getUser();
        this.storageValidator.uniqueID(user.getId(), this);

        this.users.add(user);
    }

    @Override
    public List<Account> getAccounts() {
        return new ArrayList<>(this.accounts);
    }

    @Override
    public Account getAccount(String account_id) {
        for (Account a : this.accounts) {
            if (a.getId().equals(account_id)) {
                return a;
            }
        }

        throw new ElementNotFoundException("Account with ID " + account_id + " not found");
    }

    @Override
    public void addAccount(Account account) {
        this.storageValidator.uniqueID(account.getId(), this);

        this.accounts.add(account);
    }

    @Override
    public List<Transaction> getTransactions() {
        return new ArrayList<>(this.transactions);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    @Override
    public void editBalance(Account account, double value) {
        account.setBalance(value);
    }

}
