package com.consultorio.management.error;

import lombok.*;

import java.time.ZonedDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    private String title;
    private String message;
    private ZonedDateTime timeStamp;
}
