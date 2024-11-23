/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.interfaces.IUserController;
import core.controllers.utils.Response;
import core.controllers.interfaces.Status;
import core.controllers.utils.Validator;
import core.models.interfaces.IUserRepository;
import core.models.User;
import java.util.List;

/**
 *
 * @author jose
 */
public class UserController implements IUserController {

    private final IUserRepository userRepository;

    /**
     * Instances the user controller
     * @param userRepository repository for user data
     */
    public UserController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.getUsers();
    }

    @Override
    public Response createUser(String id, String firstname, String lastname, String age) {
        User user;

        try {
            try {
                user = Validator.validateUserInput(id, firstname, lastname, age);
                this.userRepository.addUser(user);
            } catch (IllegalArgumentException e) {
                return new Response(e.getMessage(), Status.BAD_REQUEST);
            }

            return new Response("User created succesfully", Status.CREATED);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
