/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.interfaces;

import core.models.User;
import java.util.List;

/**
 *
 * @author jose
 */
public interface IUserGetters {

    /**
     * Getter for the users list property
     *
     * @return users list
     */
    List<User> getUsers();

    /**
     * Get a single user
     *
     * @param user_id user id
     * @return user object
     */
    User getUser(int user_id);
}
