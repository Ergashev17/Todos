package org.example.todo_spring_boot.repo;

import org.example.todo_spring_boot.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}