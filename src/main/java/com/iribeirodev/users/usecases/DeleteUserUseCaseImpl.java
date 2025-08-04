package com.iribeirodev.users.usecases;

import java.util.UUID;

import com.iribeirodev.users.entities.UserEntity;
import com.iribeirodev.users.exceptions.UserNotFoundException;
import com.iribeirodev.users.usecases.interfaces.DeleteUserUseCase;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    @Override
    public void deleteById(UUID userId) {
        var user = (UserEntity) UserEntity.findByIdOptional(userId)
                        .orElseThrow(UserNotFoundException::new);

        UserEntity.deleteById(user.userId);        
    }

}
