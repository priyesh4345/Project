package com.example.crud.Controller;


import com.example.crud.Service.StudentService;
import com.example.crud.payload.StudentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;

    }

    @PostMapping
    //http://localhost:8080/api/Student
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto save = studentService.createStudent(studentDto);
        return new ResponseEntity<>(save, HttpStatus.ACCEPTED);
    }

  @GetMapping
    public List<StudentDto> getallstudent(){
        List<StudentDto> studentdto = studentService.getallstudent();
        return studentdto;
    }

    @GetMapping("/{id}")
    //http://localhost:8080/api/Student/1
    public ResponseEntity<StudentDto>  getstudentbyid(@PathVariable("id") Long id ){
        StudentDto studentDto = studentService.getstudentbyid(id);
        return new ResponseEntity<>(studentDto , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updatepost(@PathVariable("id") Long id , @RequestBody StudentDto studentDto){
        StudentDto dto = studentService.updatepost(id , studentDto);
        return new ResponseEntity<>(dto , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletestudent(@PathVariable("id") long id){
        studentService.deletestudent(id);
        return new ResponseEntity<>("Post is deleted", HttpStatus.OK);
    }


}
