package me.drigster.todo.Services;

import me.drigster.todo.Models.Todo;
import me.drigster.todo.Repositories.TodoRepository;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Iterable<Todo> get() {
        return todoRepository.findAll();
    }
    public Todo getById(Integer id) {
        return todoRepository.findById(id).orElse(null);
    }
    public void removeById(Integer id) {
        todoRepository.deleteById(id);
    }
    public void put(Todo todo) {
        todoRepository.save(todo);
    }

    public void removeAll() {
        todoRepository.deleteAll();
    }

    public void update(@Valid Todo todo) {
        todoRepository.save(todo);
    }

}
