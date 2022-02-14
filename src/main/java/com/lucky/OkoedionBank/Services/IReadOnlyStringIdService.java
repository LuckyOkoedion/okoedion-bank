package com.lucky.OkoedionBank.Services;

import java.util.List;

public interface IReadOnlyStringIdService<T> {
    List<T> getAll();
    T getOneById(String id);
}
