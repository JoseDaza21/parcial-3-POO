/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.interfaces;

import core.models.Account;
import core.models.utils.TransactionType;

/**
 *
 * @author jose
 */
public interface ITransaction {

    /**
     * Getter for the transaction type
     *
     * @return transaction type
     */
    TransactionType getType();

    /**
     * Getter for the source account
     *
     * @return source account
     */
    Account getSourceAccount();

    /**
     * Getter for the destination account
     *
     * @return destination account
     */
    Account getDestinationAccount();

    /**
     * Getter for the transaction amount
     *
     * @return transaction amount
     */
    double getAmount();
}
