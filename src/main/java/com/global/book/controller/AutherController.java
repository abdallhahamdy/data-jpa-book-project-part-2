package com.global.book.controller;

import com.global.book.entity.Auther;
import com.global.book.entity.AutherSearch;
import com.global.book.service.AutherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Validated
@RestController
@RequestMapping("/auther")
public class AutherController {

    @Autowired
    private AutherService autherService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(autherService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(autherService.findAll());
    }

    @PostMapping()
    public ResponseEntity<?> insert(@RequestBody @Valid Auther entity) {
        return ResponseEntity.ok(autherService.insert(entity));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody @Valid Auther entity) {
        return ResponseEntity.ok(autherService.update(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        autherService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/spec")
    public ResponseEntity<?> findByAutherSpec(@RequestBody AutherSearch search){

        return ResponseEntity.ok(autherService.findByAutherSpec(search));
    }
}
