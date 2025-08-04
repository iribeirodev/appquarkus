package com.iribeirodev.users.usecases;

import java.util.UUID;

import com.iribeirodev.users.entities.UserEntity;
import com.iribeirodev.users.exceptions.UserNotFoundException;
import com.iribeirodev.users.usecases.interfaces.FindUserUseCase;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FindUserUseCaseImpl implements FindUserUseCase {

    @Override
    public UserEntity findById(UUID userId) {
        return (UserEntity) UserEntity.findByIdOptional(userId)
                        .orElseThrow(UserNotFoundException::new);    
    }

}
