package com.consultorio.management.exception;

public class MedicNotFoundException extends RuntimeException {

    public MedicNotFoundException(Long id) {
        super("Medic not found with id: " + id);
    }
}
