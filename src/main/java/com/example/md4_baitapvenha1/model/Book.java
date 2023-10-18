package com.example.md4_baitapvenha1.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Book() {
    }

    public Book(Long idBook, String name, Category category) {
        this.idBook = idBook;
        this.name = name;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public Long getIdBook() {
        return idBook;
    }
}
