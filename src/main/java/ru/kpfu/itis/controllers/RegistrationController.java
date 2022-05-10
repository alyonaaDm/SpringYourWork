package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.dto.SignUpDto;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.services.UsersService;

@Controller
@RequestMapping("/signUp")
public class RegistrationController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ModelAndView doGet() {
        return new ModelAndView("signUp");
    }

    @PostMapping
    public ModelAndView register(SignUpDto signUpDto) {
        ModelAndView modelAndView = new ModelAndView();

        UserForm userForm = new UserForm();
        userForm.setLogin(signUpDto.getLogin());
        userForm.setPassword(signUpDto.getPassword());
        userForm.setFirstName(signUpDto.getFirstName());
        userForm.setLastName(signUpDto.getLastName());

        usersService.register(userForm);
        modelAndView.setViewName("redirect:/signIn");
        return modelAndView;
    }
}
