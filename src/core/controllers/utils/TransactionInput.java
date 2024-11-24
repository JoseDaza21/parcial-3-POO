/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils;

import core.models.utils.TransactionType;

/**
 *
 * @author jose
 */
public class TransactionInput {

    public final TransactionType type;
    public final String source_account;
    public final String destination_account;
    public final double amount;

    public TransactionInput(TransactionType type, String source_account, String destination_account, double amount) {
        this.type = type;
        this.source_account = source_account;
        this.destination_account = destination_account;
        this.amount = amount;
    }
}
