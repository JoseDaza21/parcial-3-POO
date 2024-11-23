/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.interfaces;

import core.models.User;
import java.util.ArrayList;

/**
 *
 * @author jose
 */
public interface IStorage extends IGetters {
     /**
     * Adds a new user to the internal storage
     * @param user user to be added
     * @throws IllegalArgumentException if ID already exists
     */
    void addUser(User user);
}
