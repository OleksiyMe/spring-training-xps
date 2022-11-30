package com.cydeo.controller;


import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final StudentService studentService;
    private final TeacherService teacherService;
    private final ParentService parentService;
    private final AddressService addressService;

    public SchoolController(StudentService studentService, TeacherService teacherService, ParentService parentService, AddressService addressService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.parentService = parentService;
        this.addressService = addressService;
    }


    @GetMapping("/teachers")

    public List<TeacherDTO> readAllTeacher() {

        List<TeacherDTO> teachers = teacherService.findAll();
        return teachers;

    }


    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> getAllStudents() {


        return ResponseEntity.ok(
                new ResponseWrapper("Parents are retrieved",
                        studentService.findAll())
        );
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> getAllParents() {

        ResponseWrapper responseWrapper =
                new ResponseWrapper(true, "Students are successfully retrieved",
                        HttpStatus.I_AM_A_TEAPOT.value(), parentService.findAll());

        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
                .body(responseWrapper);
    }


    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> getAllParents(
            @PathVariable("id") Long id) throws Exception {

        AddressDTO addressDTO = addressService.findById(id);

        return ResponseEntity.ok(
                new ResponseWrapper("Address is successfully retrieved", addressDTO)
        );
    }

    @PutMapping("/address/{id}")
    public AddressDTO updateAddress(
            @PathVariable("id") Long id, @RequestBody AddressDTO addressDTO) throws Exception {

        addressDTO.setId(id);

        return addressService.update(addressDTO);
    }
}
