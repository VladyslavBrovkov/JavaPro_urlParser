package academy.prog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/")
public class LoginController {

    @GetMapping("/login")
    public String loginForm() {
        return "login.html";
    }

    @GetMapping("/homepage")
    public String homeForm() {
        return "homepage.html";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "adminpage.html";
    }


}
