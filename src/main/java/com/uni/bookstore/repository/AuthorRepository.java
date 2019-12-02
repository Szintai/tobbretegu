package com.uni.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uni.bookstore.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
