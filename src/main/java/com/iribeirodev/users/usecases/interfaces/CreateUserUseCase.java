package com.iribeirodev.users.usecases.interfaces;

import com.iribeirodev.users.entities.UserEntity;

public interface CreateUserUseCase {
    UserEntity createUser(UserEntity userEntity);
}
