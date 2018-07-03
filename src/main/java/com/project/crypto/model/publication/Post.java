package com.project.crypto.model.publication;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Posts")
public class Post extends Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 50)
    @NotNull
    private String title;


    @Column(length = 160)
    @NotNull
    private String description;

    @Lob
    @NotNull
    private String content;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
