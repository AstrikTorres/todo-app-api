package com.astrik.todoappapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "todos")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    @NotNull(message = "the id is needed to update", groups = ToDoUpdate.class)
    private Long id;

    @Column(name = "text", nullable = false)
    @NotBlank(message = "The text cannot be blank.", groups = {ToDoCreate.class, ToDoUpdate.class})
    private String text;

    @Column(name = "completed", columnDefinition = "boolean default false")
    @NotNull(message = "The completed property must have a boolean value.", groups = {ToDoCreate.class, ToDoUpdate.class})
    private Boolean completed;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    public ToDo(String text, Boolean completed) {
        this.text = text;
        this.completed = completed;
    }

    public ToDo() {

    }

    public ToDo(String text, Boolean completed, User user) {
        this.text = text;
        this.completed = completed;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
