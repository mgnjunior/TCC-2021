package com.consultorio.management.entity.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientRecordReponse {

    private Long value;
    private String label;
}
