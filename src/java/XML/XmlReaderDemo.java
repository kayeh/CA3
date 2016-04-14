package XML;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import entity.ExchangeRates;
import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import java.net.URL;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class XmlReaderDemo extends DefaultHandler {

    static ExchangeRates er;
    String currDate;
    String currRate;
    String currDesc;
    String currCode;

    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU-Local");
        // THE ER in the PU name is for Exchange Rates!
        EntityManager em = emf.createEntityManager();

        for (int i = 0; i < attributes.getLength(); i++) {

            ////  From here --- Just to find the date
            if (attributes.getValue(i).length() > 3) {
                if (attributes.getValue(i).substring(0, 4).equals("2016")) {
                    currDate = attributes.getValue(i);
                    //System.out.println(currDate);
                }
            }
         ////To here --- Just to find the date

            if (attributes.getLocalName(i).equals("code")) {
                currCode = attributes.getValue(i);
                //  System.out.println(currCode);
            }
            if (attributes.getLocalName(i).equals("rate")) {
                if(attributes.getValue(i).equals("-")){
                    currRate = "0.00";
                }else{
                     currRate = attributes.getValue(i);
                }
               
                // System.out.println(currRate);
            }
            if (attributes.getLocalName(i).equals("desc")) {
                currDesc = attributes.getValue(i);
                // System.out.println(currDesc);
            }
        }
        try {
            if(currCode.length() > 0){
            er = new ExchangeRates(currCode, currRate, currDesc, currDate);
            }
            em.getTransaction().begin();
            em.persist(er);
            em.getTransaction().commit();

        } catch (Exception e) {
        } finally {
            em.close();
        }
    }

    public static void main(String[] argv) {

        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setContentHandler(new XmlReaderDemo());
            URL url = new URL("http://www.nationalbanken.dk/_vti_bin/DN/DataService.svc/CurrencyRatesXML?lang=en");
            xr.parse(new InputSource(url.openStream()));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

    }
}
