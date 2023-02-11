package com.global.book.service;

import com.global.book.Base.BaseService;
import com.global.book.entity.Auther;
import com.global.book.entity.AutherSearch;
import com.global.book.error.DuplicateRecordException;
import com.global.book.repository.AutherRepo;
import com.global.book.repository.AutherSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class AutherService extends BaseService<Auther, Long> {

    @Autowired
    private AutherRepo autherRepo;

    Logger log = LoggerFactory.getLogger(AutherService.class);

    @Override
    public Auther insert(Auther entity) {

        if (!entity.getEmail().isEmpty() && entity.getEmail() != null) {
            CompletableFuture<Auther> auther = findByEmail(entity.getEmail());

            log.info("author name is {} and email is {} ", entity.getName(), entity.getEmail());

            if (auther.isDone()) {
                log.error("This email already found with another auther ");
                throw new DuplicateRecordException("This email already found with another auther ");
            }
        }

        return super.insert(entity);
    }
    @Override
    public Auther update(Auther entity) {

        Auther auther = findById(entity.getId());

        auther.setName(entity.getName());

        return super.update(entity);
    }

    public List<Auther> findByAutherSpec(AutherSearch search) {

        AutherSpec spec = new AutherSpec(search);

        return autherRepo.findAll(spec);

    }

    @Async(value = "threadPoolTaskExecutor")
    public CompletableFuture<Auther> findByEmail(String email) {

        return CompletableFuture.completedFuture(autherRepo.findByEmail(email).get());
    }


}
