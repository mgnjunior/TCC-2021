package com.consultorio.management.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordsUpdateRequest extends RecordsRequest implements Records {

    private Long id;

}
