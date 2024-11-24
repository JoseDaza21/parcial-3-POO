/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.interfaces;

import core.models.Transaction;

/**
 *
 * @author jose
 */
public interface ITransactionRepository extends ITransactionGetters {

    /**
     * Add a new transaction to the storage
     *
     * @param transaction transaction information
     */
    void addTransaction(Transaction transaction);
}
