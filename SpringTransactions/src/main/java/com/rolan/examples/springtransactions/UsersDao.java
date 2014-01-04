/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolan.examples.springtransactions;

import com.rolan.examples.springtransactions.entities.User;
import java.util.List;

/**
 *
 * @author User
 */
public interface UsersDao {
    
    List<User> getUsers();    
}
