/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import facades.UserFacade;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import entity.User;
import javax.ws.rs.PathParam;
import security.PasswordStorage;
/**
 * REST Web Service
 *
 * @author Eske Wolff
 */
@Path("create")
public class Create{
    
    Gson gson;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public Create() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    /**
     * Retrieves representation of an instance of rest.MemberResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of MemberResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Path("/createUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void createUser(String user) throws PasswordStorage.CannotPerformOperationException {
        UserFacade uf = new UserFacade();
        JsonObject jo = new JsonParser().parse(user).getAsJsonObject();
        
        User u = new User();
        u.setUserName(jo.get("userName").getAsString());
        u.setPassword(PasswordStorage.createHash(jo.get("password").getAsString()));
        
        uf.addUser(u);
    }
}
