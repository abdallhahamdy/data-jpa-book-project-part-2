package com.global.book.service;

import com.global.book.Base.BaseService;
import com.global.book.entity.Auther;
import com.global.book.entity.Book;
import com.global.book.repository.BookRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class BookService extends BaseService<Book, Long> {

    @Autowired
    private BookRepo bookRepo;

    Logger log = LoggerFactory.getLogger(BookService.class);

    public List<Book> insertAll(List<Book> entities) {
        return bookRepo.saveAll(entities);
    }

    public Book update(Book entity) {

        Book book = findById(entity.getId());
        book.setName(entity.getName());
        return update(book);
    }

    public int deleteByAutherId(Long id) {
        return bookRepo.deleteByAutherId(id);
    }
}
