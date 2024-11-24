/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.interfaces.IAccountController;
import core.controllers.interfaces.Status;
import core.controllers.utils.AccountInput;
import core.controllers.utils.ElementNotFoundException;
import core.controllers.utils.Response;
import core.controllers.utils.Validator;
import core.models.Account;
import core.models.User;
import core.models.interfaces.IAccountRepository;
import core.models.interfaces.IUserRepository;
import java.util.List;

/**
 *
 * @author jose
 */
public class AccountController implements IAccountController {

    private final IAccountRepository accountRepository;
    private final IUserRepository userRepository;

    /**
     * Instances the account controller
     *
     * @param accountRepository repository for accounts data
     * @param userRepository repository for users data
     */
    public AccountController(IAccountRepository accountRepository, IUserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Account> getAccounts() {
        return this.accountRepository.getAccounts();
    }

    @Override
    public Account getAccount(String account_id) {
        return this.accountRepository.getAccount(account_id);
    }

    @Override
    public Response createAccount(String user_id, String initial_balance) {
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
