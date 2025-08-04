package com.iribeirodev.users.controllers;

import java.util.UUID;

import com.iribeirodev.users.entities.UserEntity;
import com.iribeirodev.users.usecases.interfaces.CreateUserUseCase;
import com.iribeirodev.users.usecases.interfaces.DeleteUserUseCase;
import com.iribeirodev.users.usecases.interfaces.FindAllUsersUseCase;
import com.iribeirodev.users.usecases.interfaces.FindUserUseCase;
import com.iribeirodev.users.usecases.interfaces.UpdateUserUseCase;

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
    private final CreateUserUseCase createUserService;
    private final FindAllUsersUseCase findAllUsersService;
    private final FindUserUseCase findUserService;
    private final UpdateUserUseCase updateUserService;
    private final DeleteUserUseCase deleteUserService;

    public UserController(
        //UserService userService)
        CreateUserUseCase createUserUseCase,
        FindAllUsersUseCase findAllUsersUseCase,
        FindUserUseCase findUserUseCase,
        UpdateUserUseCase updateUserUseCase,
        DeleteUserUseCase deleteUserUseCase)
    {
        this.createUserService = createUserUseCase;
        this.findAllUsersService = findAllUsersUseCase;
        this.findUserService = findUserUseCase;
        this.updateUserService = updateUserUseCase;
        this.deleteUserService = deleteUserUseCase;
    }

    @GET
    public Response findAll(
        @QueryParam("page") @DefaultValue("0") Integer page, 
        @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        return Response.ok(findAllUsersService.findAll(page, pageSize)).build();
    }

    @Path("/{id}")
    @GET
    public Response findById(@PathParam("id") UUID userId) {
        return Response.ok(findUserService.findById(userId)).build();
    }    

    @POST
    @Transactional
    public Response createUser(UserEntity userEntity) {
        return Response.ok(createUserService.createUser(userEntity)).build();
    }

    @Path("/{id}")
    @PUT
    @Transactional
    public Response updateUser(@PathParam("id") UUID userId, UserEntity userEntity) {
        return Response.ok(updateUserService.updateUser(userId, userEntity)).build();
    }

    @Path("/{id}")
    @DELETE
    @Transactional
    public Response deleteUser(@PathParam("id") UUID userId) {
        deleteUserService.deleteById(userId);
        return Response.noContent().build();
    }     

}
