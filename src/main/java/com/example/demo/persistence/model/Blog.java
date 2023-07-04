package com.example.demo.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import java.time.Instant;

@Data
@AllArgsConstructor public class Blog {
    int blogId;
    int userId;
    @Size(max = 20)
    @Pattern(regexp = "[^;]+")
    String title;
    @Pattern(regexp = "[^;]+")
    @Size(max = 20)
    String content;
    Instant timeCreated;
    Instant timeLastModified;

}