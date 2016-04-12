/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Role;
import entity.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import openshift_deploy.DeploymentConfiguration;
import security.PasswordStorage;

/**
 *
 * @author Eske Wolff
 */
public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU-Local");
        EntityManager em = emf.createEntityManager();

        Role userRole = new Role("User");
        Role adminRole = new Role("Admin");

        User user = new User("user", "test");
        User admin = new User("admin", "test");
        User both = new User("user_admin", "test");
        user.AddRole(userRole);
        admin.AddRole(adminRole);
        both.AddRole(userRole);
        both.AddRole(adminRole);

        try {
            em.getTransaction().begin();
            em.persist(userRole);
            em.persist(adminRole);

            em.persist(user);
            em.persist(admin);
            em.persist(both);
            em.getTransaction().commit();

        } catch (Exception e) {
        }
    }
}
