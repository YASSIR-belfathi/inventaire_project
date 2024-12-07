package controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
    @GetMapping("/Test")
    public String showTest() {
        return "Test";  // Renvoie la page login.html
    }
}
