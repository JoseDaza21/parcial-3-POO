/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.repositories;

import core.models.Transaction;
import core.models.interfaces.IStorage;
import core.models.interfaces.ITransactionRepository;
import java.util.List;

/**
 *
 * @author jose
 */
public class TransactionRepository implements ITransactionRepository {

    private final IStorage storage;

    /**
     * Repository instance for handling storage
     *
     * @param storage storage instance
     */
    public TransactionRepository(IStorage storage) {
        this.storage = storage;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        this.storage.addTransaction(transaction);
    }

    @Override
    public List<Transaction> getTransactions() {
        return this.storage.getTransactions();
    }
}
