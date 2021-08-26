package com.consultorio.management.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicRequest {

    private String firstName;
    private String secondName;
    private String email;
    private Long crm;

}
