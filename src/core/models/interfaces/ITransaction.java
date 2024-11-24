/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.interfaces;

import core.models.Account;
import core.models.utils.TransactionType;

/**
 *
 * @author jose
 */
public interface ITransaction {

    TransactionType getType();

    Account getSourceAccount();

    Account getDestinationAccount();

    double getAmount();
}
