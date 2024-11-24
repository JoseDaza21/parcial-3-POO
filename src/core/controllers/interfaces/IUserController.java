/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.controllers.interfaces;

import core.controllers.utils.Response;
import core.models.interfaces.IUserGetters;

/**
 *
 * @author jose
 */
public interface IUserController extends IUserGetters {

    /**
     * Create a new user
     * @param id user id: 0 or more and up to 9 digits length
     * @param firstname user first name
     * @param lastname user last name
     * @param age user age
     * @return response message
     */
    Response createUser(String id, String firstname, String lastname, String age);
}
