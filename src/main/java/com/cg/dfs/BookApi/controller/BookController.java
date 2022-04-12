package com.cg.dfs.BookApi.controller;

import com.cg.dfs.BookApi.model.Book;
import com.cg.dfs.BookApi.service.BookService;
import com.cg.dfs.BookApi.util.FieldErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController

public class BookController {

    @Autowired
    private BookService bookService;


    // Save operation
    @PostMapping("/book/add")
    public Book saveBook(@Valid @RequestBody Book book)
    {
        return bookService.saveBook(book);
    }

    // Read operation
    @GetMapping("/book/get")
    public List<Book> getBook()
    {
        return bookService.getBook();
    }



    // Exception Handling
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e){
       List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
       List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream()
               .map(fieldError -> new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()))
               .collect(Collectors.toList());

       return fieldErrorMessages;

    }


}
