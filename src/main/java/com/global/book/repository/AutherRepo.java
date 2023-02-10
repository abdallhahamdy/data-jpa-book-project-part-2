package com.global.book.repository;

import com.global.book.Base.BaseRepository;
import com.global.book.entity.Auther;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface AutherRepo extends BaseRepository<Auther, Long>, JpaSpecificationExecutor<Auther> {

//    @Transactional
//    @Query(value = "UPDATE Auther a SET a.isDeleted = false WHERE a.id = ?1")
//    @Modifying
//    public void restoreById(Long id);

    Optional<Auther> findByEmail(String email);
}
