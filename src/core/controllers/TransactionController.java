/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.interfaces.ITransactionController;
import core.controllers.interfaces.Status;
import core.controllers.utils.Response;
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
        try {
            try {
                AccountInput input = Validator.validateAccountInput(user_id, initial_balance);

                User user = this.userRepository.getUser(input.user_id);
                Account account = new Account(Validator.generateRandomID(), user, input.initial_balance);

                this.accountRepository.addAccount(account);
            } catch (IllegalArgumentException e) {
                return new Response(e.getMessage(), Status.BAD_REQUEST);
            } catch (ElementNotFoundException e) {
                return new Response(e.getMessage(), Status.NOT_FOUND);
            }

            return new Response("Account created succesfully", Status.CREATED);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }

    }
}
