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
public interface IAccount {

    String getId();

    User getOwner();

    double getBalance();

    void deposit(double amount);

    boolean withdraw(double amount);
}
