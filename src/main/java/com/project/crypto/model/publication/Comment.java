package com.project.crypto.model.publication;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.crypto.model.person.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Comments")
public class Comment extends Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @NotNull
    private String content;


    @ManyToOne
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", nullable = false)
    @JsonIgnore
    private Post post;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
