/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolan.examples.springtransactions;

import com.rolan.examples.springtransactions.entities.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class SimpleUsersDao implements UsersDao {

    public List<User> getUsers() {
        User user = new User();
        user.setId(10L);
        List<User> users = new ArrayList<User>();
        users.add(user);
        return users;
    }
}
