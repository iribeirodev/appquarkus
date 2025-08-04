package com.iribeirodev.users.usecases;

import java.util.List;

import com.iribeirodev.users.entities.UserEntity;
import com.iribeirodev.users.usecases.interfaces.FindAllUsersUseCase;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FindAllUsersUseCaseImpl implements FindAllUsersUseCase{

    @Override
    public List<UserEntity> findAll(Integer page, Integer pageSize) {
        return UserEntity.findAll()
                    .page(page, pageSize)
                    .list();        
    }
    
}
