/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.controllers.interfaces;

import core.controllers.utils.Response;
import core.models.interfaces.IAccountGetters;

/**
 *
 * @author jose
 */
public interface IAccountController extends IAccountGetters {

    /**
     * Creates an account
     * @param user_id user id
     * @param initial_balance initial balance
     * @return returns a response for the view
     */
    Response createAccount(String user_id, String initial_balance);
}
