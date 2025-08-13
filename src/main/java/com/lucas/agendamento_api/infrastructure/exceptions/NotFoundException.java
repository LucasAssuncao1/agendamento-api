package com.lucas.agendamento_api.infrastructure.exceptions;

public class NotFoundException extends RuntimeException{
    
    public NotFoundException(String message){
        super(message);
    }

}
