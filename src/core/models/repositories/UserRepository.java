/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.repositories;

import core.models.User;
import core.models.storage.Storage;

/**
 *
 * @author jose
 */
public class UserRepository implements IUserRepository {

    @Override
    public boolean addUser(User user) {
        Storage storage = Storage.getInstance();
        
        return storage.addUser(user);
    }
}
