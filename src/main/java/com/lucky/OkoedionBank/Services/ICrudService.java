package com.lucky.OkoedionBank.Services;

import java.util.List;

public interface ICrudService <T> {
    List<T> getAll();

    T create(T theObj);

    T getOneById(Long id);

    void update(T theObj);

    void destroy(Long id);
}
