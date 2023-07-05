package com.example.demo.persistence.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * The type User.
 */
@Data
@AllArgsConstructor
public class User {
    /**
     * The Max name length.
     */
    static final int MAX_NAME_LENGTH = 20;
    /**
     * The User id.
     */
    private int userId;
    /**
     * The Name.
     */
    @NotBlank
    @NotNull
    @Size(max = MAX_NAME_LENGTH)
    @Pattern(regexp = "[a-zA-Z ]+")
    private String name;
}
