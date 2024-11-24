/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.interfaces.ITransactionController;
import core.controllers.interfaces.Status;
import core.controllers.utils.ElementNotFoundException;
import core.controllers.utils.Response;
import core.controllers.utils.TransactionInput;
import core.controllers.utils.Validator;
import core.models.Account;
import core.models.Transaction;
import core.models.interfaces.IAccountRepository;
import core.models.interfaces.ITransactionRepository;
import core.models.utils.TransactionType;
import java.util.List;

/**
 *
 * @author jose
 */
public class TransactionController implements ITransactionController {

    private final ITransactionRepository transactionRepository;
    private final IAccountRepository accountRepository;

    /**
     * Instances the account controller
     *
     * @param accountRepository repository for accounts data
     * @param transactionRepository repository for transactions data
     */
    public TransactionController(ITransactionRepository transactionRepository, IAccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Transaction> getTransactions() {
        return this.transactionRepository.getTransactions();
    }

    @Override
    public Response createTransaction(String type, String source_account, String destination_account, String amount) {
        Account source = null;
        Account destination = null;

        try {
            try {
                TransactionInput input = Validator.validateTransactionInput(type, source_account, destination_account, amount);

                if (input.type == TransactionType.WITHDRAW || input.type == TransactionType.TRANSFER) {
                    try {
                        source = accountRepository.getAccount(source_account);
                    } catch (ElementNotFoundException e) {
                        return new Response("Source account doest not exist", Status.NOT_FOUND);
                    }

                    if (input.amount > source.getBalance()) {
                        throw new IllegalArgumentException("Insufficient funds in the source account");
                    }

                    this.accountRepository.editBalance(source, source.getBalance() - input.amount);
                }

                if (input.type == TransactionType.DEPOSIT || input.type == TransactionType.TRANSFER) {
                    try {
                        destination = accountRepository.getAccount(destination_account);

                        this.accountRepository.editBalance(destination, destination.getBalance() + input.amount);
                    } catch (ElementNotFoundException e) {
                        return new Response("Destination account doest not exist", Status.NOT_FOUND);
                    }
                }

                Transaction transaction = new Transaction(input.type, source, destination, input.amount);

                this.transactionRepository.addTransaction(transaction);
            } catch (IllegalArgumentException e) {
                return new Response(e.getMessage(), Status.BAD_REQUEST);
            }

            return new Response("Transaction created succesfully", Status.CREATED);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }

    }
}
