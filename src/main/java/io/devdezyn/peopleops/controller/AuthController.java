package io.devdezyn.peopleops.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class AuthController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "auth/login";

    }

    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "auth/access-denied";

    }
}
