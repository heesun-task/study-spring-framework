package com.hs.springboot.firstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("username")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/list-todos")
    public String showTodoListPage(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("hs");
        model.addAttribute("todos", todos);
        return "list-todos";
    }

    @RequestMapping(value="/add-todo", method= RequestMethod.GET)
    public String showAddTodoPage(ModelMap model) {

        String username = (String) model.get("username");
        Todo todo = new Todo(0, username, "Default Description", LocalDate.now(), false);
        model.put("todo", todo);
        return "add-todo";
    }
    @RequestMapping(value="/add-todo", method= RequestMethod.POST )
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "add-todo";
        }
        String username = (String) model.get("username");
        todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(value="/delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodoById(id);
        return "redirect:/list-todos";
    }
}
