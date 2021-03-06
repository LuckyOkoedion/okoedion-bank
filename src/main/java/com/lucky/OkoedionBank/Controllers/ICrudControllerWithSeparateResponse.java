package com.lucky.OkoedionBank.Controllers;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ICrudControllerWithSeparateResponse<T, E> {
    @GetMapping
    ResponseEntity<List<E>> getAll();

    @PostMapping
    ResponseEntity<E> create(@RequestBody T theObj);

    @GetMapping("/{id}")
    ResponseEntity<E> getOneById(@PathVariable(value="id") Long id);

    @PutMapping
    void update(@RequestBody T theObj) throws ChangeSetPersister.NotFoundException;

    @DeleteMapping("/{id}")
    void destroy(@PathVariable(value = "id") Long id);
}
