package com.global.book.config;

import com.global.book.entity.Auther;
import com.global.book.entity.Book;
import com.global.book.service.AutherService;
import com.global.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartupApp implements CommandLineRunner {

    @Autowired
    private AutherService autherService;

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {

        // adding some data for authers
        if (autherService.findAll().isEmpty()) {
            Auther auther1 = new Auther();
            auther1.setName("Ali");

            Auther auther2 = new Auther();
            auther2.setName("Mohammed");

            Auther auther3 = new Auther();
            auther3.setName("Ahmed");

            autherService.insertAll(Arrays.asList(auther1, auther2, auther3));
        }

        // adding some data for books
        if (bookService.findAll().isEmpty()) {
            Book book1 = new Book();
            book1.setName("Java JPA");
            book1.setPrice(200);
            book1.setAuther(autherService.getById(1L));


            Book book2 = new Book();
            book2.setName("Data Base Mysql");
            book2.setPrice(300);
            book2.setAuther(autherService.getById(1L));


            Book book3 = new Book();
            book3.setName("Python");
            book3.setPrice(120);
            book3.setAuther(autherService.findById(2L));


            bookService.insertAll(Arrays.asList(book1, book2, book3));
        }
        }
}
