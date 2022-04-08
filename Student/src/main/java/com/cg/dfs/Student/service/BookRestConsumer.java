package com.cg.dfs.Student.service;


import com.cg.dfs.Student.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "BOOK-SERVICE")
public interface BookRestConsumer {

    @GetMapping("/book/get")
    public List<Book> getBook();

}
