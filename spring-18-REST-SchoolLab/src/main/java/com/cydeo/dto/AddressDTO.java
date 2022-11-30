package com.cydeo.dto;

import com.cydeo.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//@JsonIgnoreProperties(value={"id"},ignoreUnknown = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO {

    @JsonIgnore
    private Long id;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;

    private AddressType addressType;

    @JsonBackReference(value = "student-address-reference")                 //defReference
    private StudentDTO student;

    @JsonBackReference(value = "parent-address-reference")                    //defReference
    private ParentDTO parent;

    @JsonBackReference(value = "teacher-address-reference")                      //defReference
    private TeacherDTO teacher;


    private Integer currentTemperature;     //weather info, latter will get it from 3rd party API

}