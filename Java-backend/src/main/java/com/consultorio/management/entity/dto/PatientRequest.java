package com.consultorio.management.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequest {


    private String email;
    private String firstName;
    private String secondName;
    private String cpf;

}
