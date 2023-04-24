package com.cflox.task.converter.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessages {
    private int statusCode;
    private LocalDateTime timestamp;
    private String message;
    private String description;
}
