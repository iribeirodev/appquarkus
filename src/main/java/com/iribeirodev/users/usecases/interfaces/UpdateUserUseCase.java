package com.iribeirodev.users.usecases.interfaces;

import java.util.UUID;
import com.iribeirodev.users.entities.UserEntity;

public interface UpdateUserUseCase {
    UserEntity updateUser(UUID userId, UserEntity userEntity);
}
