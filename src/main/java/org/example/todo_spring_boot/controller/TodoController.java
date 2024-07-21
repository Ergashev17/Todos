package org.example.todo_spring_boot.controller;

import lombok.RequiredArgsConstructor;
import org.example.todo_spring_boot.entity.Todo;
import org.example.todo_spring_boot.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public String getTodos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        model.addAttribute("newToDo", new Todo());
        return "index";
    }

    @PostMapping
    public String postTodo(@ModelAttribute Todo todo) {
        todo.setCompleted(false);
        todoService.saveTodo(todo);
        return "redirect:/todos";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Integer id) {
        todoService.deleteTodosById(id);
        return "redirect:/todos";
    }

    @PostMapping("/update/{id}")
    public String updateToDoCompleted(@PathVariable Integer id, @RequestParam boolean completed) {
        Todo toDo = todoService.getToDoById(id);
        toDo.setCompleted(completed);
        todoService.saveTodo(toDo);
        return "redirect:/todos";
    }

}
