/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import core.controllers.IUserController;
import core.controllers.UserController;
import core.models.repositories.IUserRepository;
import core.models.repositories.UserRepository;
import core.views.BankView;

/**
 *
 * @author jose
 */
public class BankConfiguration {
    public static BankView createBankView() {
        // Crear las dependencias
        IUserRepository userRepository = new UserRepository();
        IUserController userController = new UserController(userRepository);
        
        // Crear y retornar la vista con sus dependencias
        return new BankView(userController);
    }
}
