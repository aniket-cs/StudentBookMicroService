package com.cg.dfs.BookApi.service;

import com.cg.dfs.BookApi.model.Book;

import java.util.List;

public interface BookService {

    // Save operation
    Book saveBook(Book book);

    // Read operation
    List<Book> getBook();
}
