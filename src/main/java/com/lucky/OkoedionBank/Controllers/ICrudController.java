package com.lucky.OkoedionBank.Controllers;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ICrudController<T> {
    @GetMapping
    ResponseEntity<List<T>> getAll();

    @PostMapping
    ResponseEntity<T> create(@RequestBody T theObj);

    @GetMapping("/{id}")
    ResponseEntity<T> getOneById(@PathVariable(value="id") Long id);

    @PutMapping
    void update(@RequestBody T theObj) throws ChangeSetPersister.NotFoundException;

    @DeleteMapping("/{id}")
    void destroy(@PathVariable(value = "id") Long id);
}
