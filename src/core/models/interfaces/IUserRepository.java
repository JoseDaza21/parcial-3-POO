/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.interfaces;

import core.models.User;

/**
 *
 * @author jose
 */
public interface IUserRepository extends IGetters {

    /**
     * Add a new user to the storage
     * @param user user information
     */
    void addUser(User user);
}
