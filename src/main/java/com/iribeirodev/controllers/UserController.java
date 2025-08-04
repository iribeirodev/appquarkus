package com.iribeirodev.controllers;

import java.util.UUID;

import com.iribeirodev.entities.UserEntity;
import com.iribeirodev.services.UserService;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    public Response findAll(
        @QueryParam("page") @DefaultValue("0") Integer page, 
        @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        
        var users = userService.findAll(page, pageSize);
        return Response.ok(users).build();
    }

    @Path("/{id}")
    @GET
    public Response createUser(@PathParam("id") UUID userId) {
        UserEntity response = userService.findById(userId);
        return Response.ok(response).build();
    }    

    @POST
    @Transactional
    public Response createUser(UserEntity userEntity) {
        UserEntity response = userService.createUser(userEntity);
        return Response.ok(response).build();
    }

    @Path("/{id}")
    @PUT
    @Transactional
    public Response updateUser(@PathParam("id") UUID userId, UserEntity userEntity) {
        UserEntity response = userService.updateUser(userId, userEntity);
        return Response.ok(response).build();
    }

    @Path("/{id}")
    @DELETE
    @Transactional
    public Response deleteUser(@PathParam("id") UUID userId) {
        userService.deleteById(userId);
        return Response.noContent().build();
    }     

}
