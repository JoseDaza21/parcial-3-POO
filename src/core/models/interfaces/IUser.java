/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.interfaces;

import core.models.Account;

/**
 *
 * @author jose
 */
public interface IUser {

    /**
     * Getter for the id property
     * @return id
     */
    public int getId();
    /**
     * Getter for the first name property
     * @return first name
     */
    public String getFirstname();
    /**
     * Getter for the last name property
     * @return last name
     */
    public String getLastname();
    /**
     * Getter for the age property
     * @return age
     */
    public int getAge();
    /**
     * Access to the accounts number
     * @return number of accounts
     */
    public int getNumAccounts();
    /**
     * Relate an account to the object
     * @param account account to be added
     */
    public void addAccount(Account account);
}
