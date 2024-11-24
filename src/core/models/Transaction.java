/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import core.models.utils.TransactionType;
import core.models.interfaces.ITransaction;

/**
 *
 * @author edangulo
 */
public class Transaction implements ITransaction {

    private final TransactionType type;
    private final Account sourceAccount;
    private final Account destinationAccount;
    private final double amount;

    public Transaction(TransactionType type, Account sourceAccount, Account destinationAccount, double amount) {
        this.type = type;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
    }

    @Override
    public TransactionType getType() {
        return type;
    }

    @Override
    public Account getSourceAccount() {
        return sourceAccount;
    }

    @Override
    public Account getDestinationAccount() {
        return destinationAccount;
    }

    @Override
    public double getAmount() {
        return amount;
    }

}
