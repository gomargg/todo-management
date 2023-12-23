package com.goma.todomanagement.service.impl;

import com.goma.todomanagement.dto.TodoDto;
import com.goma.todomanagement.entity.Todo;
import com.goma.todomanagement.exception.ResourceNotFoundException;
import com.goma.todomanagement.repository.TodoRepository;
import com.goma.todomanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    private final ModelMapper modelMapper;
    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        Todo todo = modelMapper.map(todoDto, Todo.class);

        Todo savedTodo = todoRepository.save(todo);


        return modelMapper.map(savedTodo, TodoDto.class);
    }

    @Override
    public TodoDto getTodo(Long id) {
        Optional<Todo> todo = Optional.ofNullable(todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id)));

        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(todo -> modelMapper.map(todo, TodoDto.class)).collect(Collectors.toList());
    }


}
