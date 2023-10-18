package com.example.md4_baitapvenha1.service.impl;

import com.example.md4_baitapvenha1.model.Book;
import com.example.md4_baitapvenha1.repository.IBookRepository;
import com.example.md4_baitapvenha1.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookRepository iBookRepository;

    @Override
    public Iterable<Book> findAll() {
        return iBookRepository.findAll();
    }
    @Override
    public Optional<Book> findById(Long id) {
        return iBookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        iBookRepository.deleteById(id);
    }
}
