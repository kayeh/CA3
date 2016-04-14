/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.graph.GraphAdapterBuilder;
import entity.Role;
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
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Eske Wolff
 */
@Path("admin")
@RolesAllowed("Admin")

public class AdminResource {

    Gson gson;
    Gson gsonUser;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public AdminResource() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        GsonBuilder gw = new GsonBuilder();
        new GraphAdapterBuilder().addType(User.class).registerOn(gw);
        gsonUser = gw.setPrettyPrinting().create();
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

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public String getMembers() {
        UserFacade uf = new UserFacade();
        JsonArray res = new JsonArray();
        List<User> users = uf.getUsers();
        for (User user : users) {
            JsonObject js1 = new JsonObject();
            js1.addProperty("username", user.getUserName());

            JsonArray roles = new JsonArray();
            List<Role> r1 = user.getRoles();
            for (Role r : r1) {
                JsonObject js2 = new JsonObject();
                js2.addProperty("role", r.getRoleName());
                roles.add(js2);
            }
            js1.add("roles", roles);

            res.add(js1);
        }
        return gson.toJson(res);

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

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeUser(@PathParam("id") String id) {
        UserFacade uf = new UserFacade();
        uf.removeUser(id);
        
    }

//    @POST
//    @Path("/create")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public void createUser(String user) throws PasswordStorage.CannotPerformOperationException {
//        UserFacade uf = new UserFacade();
//        JsonObject jo = new JsonParser().parse(user).getAsJsonObject();
//        
//        User u = new User();
//        u.setUserName(jo.get("userName").getAsString());
//        u.setPassword(PasswordStorage.createHash(jo.get("password").getAsString()));
//        
//        uf.addUser(u);
//    }
}
