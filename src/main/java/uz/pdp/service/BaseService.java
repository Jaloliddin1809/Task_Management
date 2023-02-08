package uz.pdp.service;

import uz.pdp.domain.dto.response.UserResponse;

import java.util.UUID;

public interface BaseService<T,R> {
    R add(T t);

    T getById(UUID id);
}
