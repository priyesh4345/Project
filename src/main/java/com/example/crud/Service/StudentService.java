package com.example.crud.Service;

import com.example.crud.payload.StudentDto;

import java.util.List;


public interface StudentService {
    void deletestudent(long id) ;


    public StudentDto createStudent(StudentDto studentDto) ;

    List<StudentDto> getallstudent();

    StudentDto getstudentbyid(Long id);

    StudentDto updatepost(Long id , StudentDto studentDto);
}
