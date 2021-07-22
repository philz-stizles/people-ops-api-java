package io.devdezyn.peopleops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthController {

    @GetMapping("/login")
    public String showLoginPage() {

        return "auth/login";

    }

    @GetMapping("/login")
    public String showSignupPage() {

        return "auth/login";

    }

//    // add request mapping for /access-denied
//
//    @GetMapping("/access-denied")
//    public String showAccessDenied() {
//
//        return "auth/access-denied";
//
//    }
}
