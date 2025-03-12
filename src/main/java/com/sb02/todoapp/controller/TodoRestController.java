package com.sb02.todoapp.controller;

import com.sb02.todoapp.dto.TodoAddRequestDto;
import com.sb02.todoapp.dto.TodoResponseDto;
import com.sb02.todoapp.dto.TodosResponseDto;
import com.sb02.todoapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoRestController {

    private final TodoService todoService;

    @GetMapping()
    public TodosResponseDto getAllTodos() {
        List<TodoResponseDto> todos = todoService.getAllTodos();
        return new TodosResponseDto(todos);
    }

    @PostMapping()
    public TodoResponseDto addTodo(@RequestBody TodoAddRequestDto todoAddRequestDto) {
        return todoService.addTodo(todoAddRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable String id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok(id + "  삭제");
    }

}
