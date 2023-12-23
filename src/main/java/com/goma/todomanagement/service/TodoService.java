package com.goma.todomanagement.service;

import com.goma.todomanagement.dto.TodoDto;
import com.goma.todomanagement.entity.Todo;

import java.util.List;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long id);

    List<TodoDto> getAllTodos();
}
