package com.careerdevs.helloInternet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController // This @RestController annotation is required so that the route handlers we add to the class are acknowledged and implemented. Without it, the route handlers would be ignored and rendered useless.
public class RootController {
    public static void main(String[] args) {

    }

    @GetMapping("/")
    private String rootRoute() {
        return "You requested the root route.";
    }

    @GetMapping("/random")
    private int randomNumber() {
        Random randomizer = new Random();
        int randomNumber = randomizer.nextInt(10-1) + 1;
        return randomNumber;
    }

    @GetMapping("/joke")
    private String randomJoke() {
        Random randomizer = new Random();
        String[] jokes = {"joke 1", "joke 2", "joke 3"};
        String randomJoke = jokes[randomizer.nextInt(4-1)];
        return randomJoke;
    }
}
