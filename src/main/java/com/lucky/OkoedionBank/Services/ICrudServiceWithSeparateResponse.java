package com.lucky.OkoedionBank.Services;

import java.util.List;

public interface ICrudServiceWithSeparateResponse<T, E> {
    List<E> getAll();

    E create(T theObj);

    E getOneById(Long id);

    void update(T theObj);

    void destroy(Long id);
}
