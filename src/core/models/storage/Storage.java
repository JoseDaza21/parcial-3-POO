/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storage;

import core.models.User;
import core.models.interfaces.IStorage;
import core.models.interfaces.IStorageValidator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose
 */
public class Storage implements IStorage {

    private final List<User> users;
    private final IStorageValidator storageValidator;

    /**
     * Instance the storage
     * @param storageValidator validator used for data
     */
    public Storage(IStorageValidator storageValidator) {
        this.users = new ArrayList<>();

        this.storageValidator = storageValidator;
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(this.users); // returns a copy
    }

    @Override
    public void addUser(User user) {
        this.storageValidator.uniqueUserID(user.getId(), this);

        this.users.add(user);
    }
}
