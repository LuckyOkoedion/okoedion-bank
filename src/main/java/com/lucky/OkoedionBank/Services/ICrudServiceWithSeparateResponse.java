package com.lucky.OkoedionBank.Services;

import java.util.List;

public interface ICrudServiceWithSeparateResponse<T, E, M> {
    List<T> getAll();

    E create(M theObj);

    E getOneById(Long id);

    void update(T theObj);

    void destroy(Long id);
}
