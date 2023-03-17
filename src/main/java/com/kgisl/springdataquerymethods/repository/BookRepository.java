package com.kgisl.springdataquerymethods.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kgisl.springdataquerymethods.model.Book;

public interface BookRepository extends JpaRepository<Book,Long>{
    
}