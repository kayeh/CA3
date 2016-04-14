/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import entity.ExchangeRates;
import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import security.PasswordStorage;

/**
 *
 * @author Eske Wolff
 */
public class Tester2 {

    public static void main(String[] args) throws PasswordStorage.CannotPerformOperationException, ParseException {
        // Persistence.generateSchema("PU-ER-LOCAL", null);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU-ER-LOCAL");
//        EntityManager em = emf.createEntityManager();
//        ExchangeRates er = new ExchangeRates();
//
//        er.setId(date());
//        er.setCode("DKK");
//        er.setRate("9,52");
//        er.setDescription("Denmark");
//
//        em.getTransaction().begin();
//
//        em.persist(er);
//        em.getTransaction().commit();
    }
}
