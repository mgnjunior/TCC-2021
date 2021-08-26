package com.consultorio.management.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientResponse {

    private Long id;
    private String email;
    private String firstName;
    private String secondName;
    private String cpf;


}
