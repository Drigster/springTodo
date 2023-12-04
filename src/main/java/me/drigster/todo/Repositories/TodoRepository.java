package me.drigster.todo.Repositories;

import org.springframework.data.repository.CrudRepository;

import me.drigster.todo.Models.Todo;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
    
}
