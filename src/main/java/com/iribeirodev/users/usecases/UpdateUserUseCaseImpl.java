package com.iribeirodev.users.usecases;

import java.util.UUID;

import com.iribeirodev.users.entities.UserEntity;
import com.iribeirodev.users.exceptions.UserNotFoundException;
import com.iribeirodev.users.usecases.interfaces.UpdateUserUseCase;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    @Override
    public UserEntity updateUser(UUID userId, UserEntity userEntity) {
        var user = (UserEntity) UserEntity.findByIdOptional(userId)
                        .orElseThrow(UserNotFoundException::new);

        user.username = userEntity.username;

        UserEntity.persist(user);

        return user;
    }

}
