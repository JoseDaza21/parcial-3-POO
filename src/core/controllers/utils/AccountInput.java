/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils;

/**
 *
 * @author jose
 */
public class AccountInput {

    public final int user_id;
    public final double initial_balance;

    public AccountInput(int user_id, double initial_balance) {
        this.user_id = user_id;
        this.initial_balance = initial_balance;
    }
}
