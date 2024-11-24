/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.interfaces;

import core.models.Transaction;
import java.util.List;

/**
 *
 * @author jose
 */
public interface ITransactionGetters {

    /**
     * Getter for the transactions list property
     *
     * @return users list
     */
    List<Transaction> getTransactions();
}
