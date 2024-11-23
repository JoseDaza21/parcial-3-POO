/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.repositories;

import core.models.interfaces.IUserRepository;
import core.models.User;
import core.models.interfaces.IStorage;
import java.util.List;

/**
 *
 * @author jose
 */
public class UserRepository implements IUserRepository {

    private final IStorage storage;

    /**
     * Repository instance for handling storage
     * @param storage storage instance
     */
    public UserRepository(IStorage storage) {
        this.storage = storage;
    }

    @Override
    public void addUser(User user) {
        this.storage.addUser(user);
    }

    @Override
    public List<User> getUsers() {
        return this.storage.getUsers();
    }
}
