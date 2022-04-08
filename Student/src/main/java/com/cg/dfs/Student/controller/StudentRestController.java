package com.cg.dfs.Student.controller;

import com.cg.dfs.Student.model.Book;
import com.cg.dfs.Student.service.BookRestConsumer;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRestController {

    @Autowired
    private BookRestConsumer consumer;

    @GetMapping("/allBooks")
    public List<Book> getAllBooks() {
        return consumer.getBook();
    }


}
