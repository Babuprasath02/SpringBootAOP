package com.kgisl.springdataquerymethods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kgisl.springdataquerymethods.model.Book;
import com.kgisl.springdataquerymethods.repository.BookRepository;



@Service
@Transactional

public class BookServiceImp implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByBookId(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found"));
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book b = bookRepository.findById(id).orElse(new Book());
        b.setAuthor(book.getAuthor());
        b.setId(book.getId());
        b.setPrice(book.getPrice());
        b.setTitle(book.getTitle());
        return bookRepository.save(b);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);

    }

}