package com.hs.springboot.firstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String showAddTodoPage() {
        return "add-todos";
    }
    @RequestMapping(value="/add-todo", method= RequestMethod.POST )
    public String addNewTodo(@RequestParam String description, ModelMap model) {
        String username = (String) model.get("username");
        todoService.addTodo(username, description, LocalDate.now().plusYears(1), false);
        return "redirect:/list-todos";
    }
}
