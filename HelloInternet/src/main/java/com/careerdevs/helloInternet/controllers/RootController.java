package com.careerdevs.helloInternet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController // This @RestController annotation is required so that the route handlers we add to the class are acknowledged and implemented. Without it, the route handlers would be ignored and rendered useless.
public class RootController {

    @GetMapping("/")
    private String rootRoute() {
        return "You requested the root route.";
    }

    @GetMapping("/random")
    private int randomNumber() {
        Random randomizer = new Random();
        int randomNumber = randomizer.nextInt(101-1);
        return randomNumber;
    }

    @GetMapping("/joke")
    private String randomJoke() {
        Random randomizer = new Random();
        String[] jokes = {"joke 1", "joke 2", "joke 3"};
        String randomJoke = jokes[randomizer.nextInt(4-1)];
        return randomJoke;
    }

    @GetMapping({"/number", "/number/{chosenNumber}"}) // /{chosenNumber} is a PathVariable. The value of the PathVariable is assigned below, along with the data type (String) that it will be. The chosenNumber is added manually when you type in the URL into a browser.
    public String printNumber(@PathVariable(required = false, value = "chosenNumber") String chosenNumber) { // since the path variable name and parameter name are the same, value = "chosenNumber" isn't required here, but I left it here as an example for future reference.
        return "Here's your number: " + chosenNumber + "!";
    } // This includes two different, possible paths within the {} next to GetMapping. If no number is entered, it'll return "Here's your number: null!" instead of a number. Unlike with RequestParam, the two possible paths must be included next to GetMapping.

    @GetMapping("/name")
    public String printName(@RequestParam(required = false) String name) { // In this example, I decided to exclude the value = "name" since the variable name and parameter name are the same. required = "false" makes the variable/parameter not required, and if no name is added, it'll return "Welcome, null!" instead.
        return "Welcome, " + name + "!";
    } // link example: http://localhost:8080/name?name=Taehyung

}
