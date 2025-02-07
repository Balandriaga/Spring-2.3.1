package Spring.CRUD.controllers;

import Spring.CRUD.model.User;
import Spring.CRUD.serviсe.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Slf4j
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Отображение всех пользователей
    @GetMapping()
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users/index";
    }

    // Отображение пользователя по id
    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/show";
    }

    // Форма для создания нового пользователя
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    // Создание пользователя
    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    // Форма редактирования пользователя
    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    // Обновление пользователя
    @PostMapping("/{id}/edit")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") User updatedUser) {
        updatedUser.setId(id); // Устанавливаем ID, чтобы избежать несоответствия
        userService.updateUser(updatedUser);
        return "redirect:/users";
    }

    // Удаление пользователя
    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/users";
    }
}