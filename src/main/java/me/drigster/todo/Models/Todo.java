package me.drigster.todo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import jakarta.validation.constraints.NotEmpty;

@Table("TODOS")
public class Todo {

    @Id
    private Integer id;
    @NotEmpty
    private String text;
    private Boolean isDone;
    private Integer createdAt;
    private Integer updatedAt;

    public Integer getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getIsDone() {
        return this.isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public Integer getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

}
