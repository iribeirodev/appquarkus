package com.iribeirodev.users.usecases.interfaces;

import java.util.UUID;

public interface DeleteUserUseCase {
    void deleteById(UUID userId);
}
