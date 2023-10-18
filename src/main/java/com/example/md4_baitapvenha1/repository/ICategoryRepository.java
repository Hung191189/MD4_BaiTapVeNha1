package com.example.md4_baitapvenha1.repository;

import com.example.md4_baitapvenha1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
