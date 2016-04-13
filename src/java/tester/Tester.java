/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.User;
import facades.UserFacade;
import security.PasswordStorage;

/**
 *
 * @author Eske Wolff
 */
public class Tester {
    public static void main(String[] args) throws PasswordStorage.CannotPerformOperationException {
        UserFacade uf = new UserFacade();
//        User user = new User();
//        user.setUserName("Joni2");
//        user.setPassword(PasswordStorage.createHash("test"));
//        
//        uf.addUser(user);
        uf.getUsers();
    }
}
