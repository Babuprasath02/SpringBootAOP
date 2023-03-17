package com.kgisl.springdataquerymethods;

import com.kgisl.springdataquerymethods.model.Book;

/**
 * BookBuilder
 */
public class BookBuilder {
    private Book book = new Book();
    
    public BookBuilder id(long l)
    {
        book.setId(l);
        return this;
    }
    public BookBuilder name(String author)
    {
        book.setAuthor(author);
        return this;
    }
    public Book build()
    {
        return book;
    }

}