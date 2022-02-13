package com.eea.v2.rough;

import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping(path = "/login")
public class LoginController {

    @PostMapping(path = "/getCred")
    public String getCred(@RequestBody LogIn logIn) {
        System.out.println(logIn);
        return logIn.toString();
    }
}