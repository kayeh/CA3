/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import XML.XmlReaderDemo;
import java.text.ParseException;
import security.PasswordStorage;
import facades.ExchangeRateFacade;

/**
 *
 * @author Eske Wolff
 */
public class Tester2 {

    public static void main(String[] args) throws PasswordStorage.CannotPerformOperationException, ParseException {
    ExchangeRateFacade erf = new ExchangeRateFacade();
    //ef.AddRates(args);
    
    }
}
