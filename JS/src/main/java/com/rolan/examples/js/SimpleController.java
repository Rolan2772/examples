package com.rolan.examples.js;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/greeting")
public class SimpleController {

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    Greeting greet() {
        Greeting greeting = new Greeting(1, "Hello, World!");
        System.out.println("Greeting method result: " + greeting);
        return greeting;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Boolean saveGreeting(@Valid @RequestBody Greeting greeting) {
        System.out.println("Saving greeting: " + greeting);
        return true;
    }



}
