package com.cg.dfs.Student.service;

import com.cg.dfs.Student.model.Student;

import java.util.List;

public interface StudentService {

    public Student addStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudentById(long id);


}
