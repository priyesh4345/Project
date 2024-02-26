package com.example.crud.Service.impl;

import com.example.crud.Entity.Student;
import com.example.crud.Exception.ResourceNotFoundException;
import com.example.crud.Repository.StudentRepository;
import com.example.crud.Service.StudentService;
import com.example.crud.payload.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class   StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    @Override
    public void deletestudent(long id) {
        studentRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = maptoentity(studentDto);
        Student save = studentRepository.save(student);
        //convert entity to dto
        StudentDto dto = maptodto(save);
        return dto;
    }

    @Override
    public List<StudentDto> getallstudent() {
        List<Student> student = studentRepository.findAll();

        List<StudentDto> studentdto = student.stream().map(Student -> maptodto(Student)).collect(Collectors.toList());


        return studentdto;
    }

    @Override
    public StudentDto getstudentbyid(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(id)
        );
        StudentDto studentDto = maptodto(student);
        return studentDto;
    }

    @Override
    public StudentDto updatepost(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(id)
        );
        Student updatepost = maptoentity(studentDto);
        updatepost.setId(student.getId());
        Student save = studentRepository.save(updatepost);
        return maptodto(save);
    }

    private Student maptoentity(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setAddress(studentDto.getAddress());
        student.setMobile(studentDto.getMobile());
        // You can map other properties here if needed
        return student;
    }

    private StudentDto maptodto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setAddress(student.getAddress());
        studentDto.setMobile(student.getMobile());
        // You can map other properties here if needed
        return studentDto;
    }


}
