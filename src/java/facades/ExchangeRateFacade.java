package facades;

import XML.XmlReaderDemo;
import entity.ExchangeRates;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import openshift_deploy.DeploymentConfiguration;
import security.IExchangeRates;

public class ExchangeRateFacade implements IExchangeRates {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);

    public ExchangeRateFacade() {

    }

    public List<ExchangeRates> getRates() {
        EntityManager em = emf.createEntityManager();
        List<ExchangeRates> list;
        try {

            TypedQuery<ExchangeRates> query = em.createQuery("SELECT e FROM  ExchangeRates e", ExchangeRates.class);
            list = query.getResultList();

        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public List<String> getRatesAsStrings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ExchangeRates getCode(String code) {
        EntityManager em = emf.createEntityManager();
        try {
            ExchangeRates er = em.find(ExchangeRates.class, code);
            return er;
        } finally {
            em.close();
        }
    }

    public ExchangeRates getRate(String rate) {
        EntityManager em = emf.createEntityManager();
        try {
            ExchangeRates er = em.find(ExchangeRates.class, rate);
            return er;
        } finally {
            em.close();
        }
    }

    public ExchangeRates getDesc(String desc) {
        EntityManager em = emf.createEntityManager();
        try {
            ExchangeRates er = em.find(ExchangeRates.class, desc);
            return er;
        } finally {
            em.close();
        }
    }

    @Override
    public String getRate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getResult(String amount, String fromCurrency, String toCurrency) {
        EntityManager em = emf.createEntityManager();
        List<ExchangeRates> list;
        double rate1 = 0;
        double rate2 = 0;
        double result;
        String result2;
        try {

            TypedQuery<ExchangeRates> query = em.createQuery("SELECT e FROM  ExchangeRates e", ExchangeRates.class);
            list = query.getResultList();

            for (ExchangeRates e : list) {
                if(fromCurrency.equalsIgnoreCase("dkk")){
                    rate1 = 100;
                }
                if(toCurrency.equalsIgnoreCase("dkk")){
                    rate2 = 100;
                }
                
                if (e.getCode().equalsIgnoreCase(fromCurrency)) {
                    rate1 = Double.parseDouble(e.getDescription());
                } else if (e.getCode().equalsIgnoreCase(toCurrency)) {
                    rate2 = Double.parseDouble(e.getDescription());
                }
            }
        } finally {
            em.close();
        }
        result = (Integer.parseInt(amount) * (rate1 / rate2));

        
        
      
        result2 = Double.toString(result);
        System.out.println(result2);
        return result2;
    }
    

}
