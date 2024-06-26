package com.javaguides.emsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//Used to transfer data between client and server
public class EmployeeDto {

    //Instance variables
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
