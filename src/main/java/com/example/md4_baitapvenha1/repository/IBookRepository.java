package com.example.md4_baitapvenha1.repository;

import com.example.md4_baitapvenha1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
}
