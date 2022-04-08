package com.cg.dfs.BookApi.service;

import com.cg.dfs.BookApi.model.Book;
import com.cg.dfs.BookApi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;


    // Save operation
    @Override
    public Book saveBook(Book book) {
       return bookRepository.save(book);
    }


    // Read operation
    @Override
    public List<Book> getBook() {
        return (List<Book>) bookRepository.findAll();
    }
}
