/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.interfaces;

import core.models.storage.Storage;

/**
 *
 * @author jose
 */
public interface IStorageValidator {

    /**
     * Check if an ID is not used yet
     * @param id user id
     * @param storage storage instance
     */
    public void uniqueUserID(int id, Storage storage);
}
