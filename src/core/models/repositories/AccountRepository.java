/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.repositories;

import core.models.Account;
import core.models.interfaces.IAccountRepository;
import core.models.interfaces.IStorage;
import java.util.List;

/**
 *
 * @author jose
 */
public class AccountRepository implements IAccountRepository {

    private final IStorage storage;

    /**
     * Repository instance for handling storage
     *
     * @param storage storage instance
     */
    public AccountRepository(IStorage storage) {
        this.storage = storage;
    }

    @Override
    public void addAccount(Account account) {
        this.storage.addAccount(account);
    }

    @Override
    public List<Account> getAccounts() {
        return this.storage.getAccounts();
    }

    @Override
    public Account getAccount(String account_id) {
        return this.storage.getAccount(account_id);
    }
}
