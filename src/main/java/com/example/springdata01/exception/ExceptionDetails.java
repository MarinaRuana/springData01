package com.example.springdata01.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionDetails {
    private String title;
    private String message;
    private String fields;
    private  String fieldsMassages;
    private LocalDateTime timestamp;
}
