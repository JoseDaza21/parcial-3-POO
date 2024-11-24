/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils;

/**
 *
 * @author jose
 */
public class ElementNotFoundException extends RuntimeException {

    // Constructor con mensaje personalizado
    public ElementNotFoundException(String message) {
        super(message);
    }
}
