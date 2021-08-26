package com.consultorio.management.exception;

public class RecordNotFoundException extends RuntimeException{

        public RecordNotFoundException(Long id) {
            super("Record not found with id : " + id);
        }
}
