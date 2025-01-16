package com.cg.dfs.Student.controller;

import com.cg.dfs.Student.model.Book;
import com.cg.dfs.Student.model.Student;
import com.cg.dfs.Student.service.BookRestConsumer;
import com.cg.dfs.Student.service.StudentServiceImpl;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRestController {

    @Autowired
    private BookRestConsumer consumer;

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/allBooks")
    public List<Book> getAllBooks() {
        return consumer.getBook();
    }

    @PostMapping("/add")
    public Student addStudent(@Valid @RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudent={id}")
    public Student getStudentById(@PathVariable("id") long id){
        return studentService.getStudentById(id);
    }


}
