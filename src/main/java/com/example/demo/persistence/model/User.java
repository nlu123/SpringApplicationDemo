package com.example.demo.persistence.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User {
    int userId;
    @NotBlank
    @NotNull
    @Size(max = 20)
    @Pattern(regexp = "[a-zA-Z ]+")
    String name;
}
