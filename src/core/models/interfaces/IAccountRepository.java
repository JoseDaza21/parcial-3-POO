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
public interface IAccountRepository extends IAccountGetters {

    /**
     * Add a new account to the storage
     *
     * @param account account information
     */
    void addAccount(Account account);
}
