package com.iribeirodev.users.usecases;

import com.iribeirodev.users.entities.UserEntity;
import com.iribeirodev.users.usecases.interfaces.CreateUserUseCase;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateUserUseCaseImpl implements CreateUserUseCase{

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        UserEntity.persist(userEntity);
        return userEntity;
    }

}
