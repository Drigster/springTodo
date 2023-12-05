package me.drigster.todo.Controllers;

import jakarta.validation.Valid;
import me.drigster.todo.Models.Todo;
import me.drigster.todo.Services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class IndexController {

    private final TodoService todoService;

    public IndexController(TodoService todoService){
        this.todoService = todoService;
    }

    //CREATE
    @PostMapping("/todos")
    public Todo create(@RequestBody @Valid Todo todo) {
        todoService.put(todo);
        return todo;
    }

    //READ
    @GetMapping("/todos")
    public Iterable<Todo> getTodos() {
        return todoService.get();
    }

    @GetMapping("/todo/{id}")
    public Todo getTodos(@PathVariable Integer id) {
        Todo todo = todoService.getById(id);

        if(todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return todo;
    }

    //UPDATE
    @PatchMapping("/todos")
    public void update(@RequestBody @Valid Todo todo) {
        todoService.update(todo);
    }

    //DELETE
    @DeleteMapping("/todo/all")
    public void delete() {
        todoService.removeAll();
    }

    @DeleteMapping("/todo/{id}")
    public void delete(@PathVariable Integer id) {
        todoService.removeById(id);
    }

    @GetMapping("/todo/{id}/done")
    public void markDone(@PathVariable Integer id) {
        Todo todo = todoService.getById(id);

        if(todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        todo.setIsDone(true);
        todoService.update(todo);
    }

    @GetMapping("/todo/{id}/undo")
    public void markUnDone(@PathVariable Integer id) {
        Todo todo = todoService.getById(id);

        if(todo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        todo.setIsDone(false);
        todoService.update(todo);
    }
}
