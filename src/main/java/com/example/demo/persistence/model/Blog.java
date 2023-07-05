package com.example.demo.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import java.time.Instant;

/**
 * The type Blog.
 */
@Data
@AllArgsConstructor
public class Blog {

    /**
     * The Max title length.
     */
    static final int MAX_TITLE_LENGTH = 20;

    /**
     * The Max content length.
     */
    static final int MAX_CONTENT_LENGTH = 20;

    /**
     * The Blog id.
     */
    private int blogId;
    /**
     * The User id.
     */
    private int userId;
    /**
     * The Title.
     */
    @Size(max = MAX_TITLE_LENGTH)
    @Pattern(regexp = "[^;]+")
    private String title;
    /**
     * The Content.
     */
    @Pattern(regexp = "[^;]+")
    @Size(max = MAX_CONTENT_LENGTH)
    private String content;
    /**
     * The Time created.
     */
    private Instant timeCreated;
    /**
     * The Time last modified.
     */
    private Instant timeLastModified;

}
