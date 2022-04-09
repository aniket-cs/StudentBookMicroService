package com.cg.dfs.BookApi.repository;

import com.cg.dfs.BookApi.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BookRepository extends CrudRepository<Book, Integer> {
}
