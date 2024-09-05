package com.project.otherServices.model;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Validated
public record Customer(
        String id,
        @NotNull(message = "Firstname is required")
        String firstname,
        String lastname,
        @NotNull(message = "Email is required")
        @Email(message = "The customer email is not correctly formatted")
        String email
) { }

