package com.iribeirodev.users.usecases.interfaces;

import java.util.UUID;
import com.iribeirodev.users.entities.UserEntity;

public interface FindUserUseCase {
    UserEntity findById(UUID userId);
}
