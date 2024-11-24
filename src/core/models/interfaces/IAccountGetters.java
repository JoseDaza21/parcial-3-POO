/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.interfaces;

import core.models.Account;
import java.util.List;

/**
 *
 * @author jose
 */
public interface IAccountGetters {
     /**
     * Getter for the users list property
     * @return users list
     */
    List<Account> getAccounts();
    
    /**
     * Getter for an specific account
     * @param account_id account id
     * @return account if found
     */
    Account getAccount(String account_id);
}
