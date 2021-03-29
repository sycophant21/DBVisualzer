package com.test.controller;

import com.test.handler.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/signup")
@Controller
public class SignUpController {

    @Autowired
    private QueryHandler queryHandler;

    @GetMapping
    public String getSignUp() {
        return "signup";
    }

    @PutMapping
    public ModelAndView createNewUser(String emailId, String pass) {
        queryHandler.insertUser(emailId, pass);
        return new ModelAndView("redirect:/login");
    }


}
