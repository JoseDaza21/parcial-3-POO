/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storage;

import core.models.Account;
import core.models.User;
import core.models.interfaces.IStorageValidator;

/**
 *
 * @author jose
 */
public class StorageValidator implements IStorageValidator {

    @Override
    public void uniqueID(int id, Storage storage) {
        for (User u : storage.getUsers()) {
            if (u.getId() == id) {
                throw new IllegalArgumentException("A person with ID" + id + " already exists");
            }
        }
    }
    
    @Override
    public void uniqueID(String id, Storage storage) {
        for (Account a : storage.getAccounts()) {
            if (a.getId().equals(id)) {
                throw new IllegalArgumentException("An account with ID" + id + " already exists");
            }
        }
    }
}
