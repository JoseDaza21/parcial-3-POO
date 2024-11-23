/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.controllers.utils.Validator;
import core.models.repositories.IUserRepository;
import core.models.User;

/**
 *
 * @author jose
 */
public class UserController implements IUserController{
    
    private final IUserRepository userRepository;
    
    public UserController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Response createUser(String id, String firstname, String lastname, String age) {
        User user;

        try {
            try {
                user = Validator.validateUserInput(id, firstname, lastname, age);
            } catch (IllegalArgumentException e) {
                return new Response(e.getMessage(), Status.BAD_REQUEST);
            }

            if (!this.userRepository.addUser(user)) {
                return new Response("A person with ID" + user.getId() + " already exists", Status.BAD_REQUEST);
            }

            return new Response("User created succesfully", Status.CREATED);
        } catch (Exception e) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
