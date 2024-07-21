package org.example.todo_spring_boot.service;


import lombok.RequiredArgsConstructor;
import org.example.todo_spring_boot.entity.Todo;
import org.example.todo_spring_boot.repo.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodosById(Integer id) {
        todoRepository.deleteById(id);
    }

    public Todo getToDoById(Integer id) {
        return todoRepository.findById(id).orElse(null);
    }

}
