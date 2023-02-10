package com.global.book.controller;

import com.global.book.entity.Book;
import com.global.book.entity.BookDTO;
import com.global.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Book book = bookService.findById(id);

        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setName(book.getName());
        dto.setPrice(book.getPrice());

        dto.setAuther(book.getAuther());

        return ResponseEntity.ok(dto);
    }

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping()
    public ResponseEntity<?> insert(@RequestBody @Valid BookDTO dto) {

        Book book = new Book();
        book.setName(dto.getName());
        book.setPrice(dto.getPrice());
        book.setAuther(dto.getAuther());

        return ResponseEntity.ok(bookService.insert(book));
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody @Valid  Book entity) {
        return ResponseEntity.ok(bookService.update(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/auther/{id}")
    public ResponseEntity<?> deleteByAutherId(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.deleteByAutherId(id));
    }
}
