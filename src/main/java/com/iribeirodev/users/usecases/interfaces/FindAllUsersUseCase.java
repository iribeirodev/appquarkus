package com.iribeirodev.users.usecases.interfaces;

import java.util.List;
import com.iribeirodev.users.entities.UserEntity;

public interface FindAllUsersUseCase {
    List<UserEntity> findAll(Integer page, Integer pageSize);
}
