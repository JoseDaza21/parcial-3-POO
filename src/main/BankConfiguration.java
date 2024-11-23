/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import core.controllers.interfaces.IUserController;
import core.controllers.UserController;
import core.models.interfaces.IStorage;
import core.models.interfaces.IStorageValidator;
import core.models.interfaces.IUserRepository;
import core.models.repositories.UserRepository;
import core.models.storage.Storage;
import core.models.storage.StorageValidator;
import core.views.BankView;

/**
 *
 * @author jose
 */
public class BankConfiguration {

    /**
     * create the Bank View with controllers, repositories, storage and needed dependencies
     * @return BankView instance
     */
    public static BankView createBankView() {
        // Crear las dependencias
        IStorageValidator storageValidator = new StorageValidator();
        IStorage storage = new Storage(storageValidator);
        
        IUserRepository userRepository = new UserRepository(storage);
        IUserController userController = new UserController(userRepository);
        
        // Crear y retornar la vista con sus dependencias
        return new BankView(userController);
    }
}
