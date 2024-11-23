/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.utils;

/**
 *
 * @author jose
 */
public class Response {
    
    private final String message;
    private final int status;
    private Object object;

    /**
     * Instances a layout for user messages
     * @param message message showed to the user
     * @param status message status
     */
    public Response(String message, int status) {
        this.message = message;
        this.status = status;
    }
    
    /**
     * Instances a layout for user messages
     * @param message message showed to the user
     * @param status message status
     * @param object object sent into the message
     */
    public Response(String message, int status, Object object) {
        this.message = message;
        this.status = status;
        this.object = object;
    }

    /**
     * Getter for message property
     * @return message string
     */
    public String getMessage() {
        return message;
    }

    /**
     * Getter for status property
     * @return status number
     */
    public int getStatus() {
        return status;
    }

    /**
     * Getter for object property
     * @return object instance
     */
    public Object getObject() {
        return object;
    }
    
}
