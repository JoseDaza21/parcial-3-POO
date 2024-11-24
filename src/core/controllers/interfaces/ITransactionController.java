/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.controllers.interfaces;

import core.controllers.utils.Response;
import core.models.interfaces.ITransactionGetters;

/**
 *
 * @author jose
 */
public interface ITransactionController extends ITransactionGetters {

    /**
     * Creates a transaction
     *
     * @param type type
     * @param source_account source account
     * @param destination_account destination account
     * @param amount amount of money
     * @return response for the view
     */
    Response createTransaction(String type, String source_account, String destination_account, String amount);
}
