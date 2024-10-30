package com.vasu.SpringJsp.Controller;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {

    //    @GetMapping("/page")
//    public String methodpage() {
//        return "page";
//    }
    private final String SAMPLE_USERNAME = "admin";
    private final String SAMPLE_PASSWORD = "password123";


    @GetMapping("/login")
    public String showLoginPage() {
        return "page";
    }

    // Handle login form submission
    @PostMapping("/validate")
    public String handleLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {

        if (SAMPLE_USERNAME.equals(username) && SAMPLE_PASSWORD.equals(password)) {
            model.addText(username);
            return "validate";  // Redirect to the welcome page if login is successful
        } else {
            model.addText("Invalid username or password");
            return "page";  // Redirect back to login page if login fails
        }
    }

}
