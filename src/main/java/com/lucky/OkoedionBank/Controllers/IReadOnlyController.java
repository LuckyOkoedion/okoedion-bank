package com.lucky.OkoedionBank.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IReadOnlyController<T, E> {
    ResponseEntity<List<T>> getAll();
    ResponseEntity<T> getOneById(@PathVariable(value="id") E id);

}
