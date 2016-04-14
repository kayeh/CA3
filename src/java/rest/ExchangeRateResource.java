/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import entity.ExchangeRates;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import facades.ExchangeRateFacade;
import java.util.List;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Eske Wolff
 */
@Path("currency")
public class ExchangeRateResource {

    Gson gson;

    @Context
    private UriInfo context;

    public ExchangeRateResource() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @GET
    @Path("/dailyrates")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        ExchangeRateFacade erf = new ExchangeRateFacade();
        //erf.getRates();

        JsonArray res = new JsonArray();
        List<ExchangeRates> rates = erf.getRates();
        JsonObject js1 = new JsonObject();
        ExchangeRates er = new ExchangeRates();

        JsonArray rates2 = new JsonArray();

        for (ExchangeRates rate : rates) {
            js1.addProperty("date", rate.getRateDate());
            JsonObject js2 = new JsonObject();
            js2.addProperty("code", rate.getCode());
            js2.addProperty("description", rate.getDescription());
            js2.addProperty("rate", rate.getRate());
            rates2.add(js2);
        }
        js1.add("rates", rates2);
        res.add(js1);

        return gson.toJson(res);
    }

    @GET
    @Path("/calculator/{amount}/{fromcurrency}/{tocurrency}")

    @Produces(MediaType.APPLICATION_JSON)
    public String CalculateData(@PathParam("amount") String amount, @PathParam("fromcurrency") String fromcurrency, @PathParam("tocurrency") String tocurrency) {
        ExchangeRateFacade erf = new ExchangeRateFacade();
        JsonObject obj1 = new JsonObject();
        
        String calculatedRes;
        calculatedRes = erf.getResult(amount, fromcurrency, tocurrency);
        obj1.addProperty("result", calculatedRes);
        return gson.toJson(obj1);
    }

}
