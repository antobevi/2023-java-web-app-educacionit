package com.antobevi.javawebappeducacionit.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        // Se puede personalizar el manejo de excepciones segun necesidades
        model.addAttribute("error", e.getMessage());

        return "error";
    }

}