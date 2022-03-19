package com.careerdevs.helloInternet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/nasa") // this causes all route handlers that are added to this class/controller to have /nasa added to their endpoints.
public class NasaController {

    @Autowired
    private Environment env;

    @GetMapping("/apod")
    public Object apodHandler(RestTemplate restTemplate) { // RestTemplate allows you to make HTTP requests from outside your server.
        return restTemplate.getForObject("https://api.nasa.gov/planetary/apod?api_key=" + env.getProperty("NASA_KEY"), Object.class);
    } // the path is /nasa/apod due to the RequestMapping "annotation" added at the beginning.

    @GetMapping("/apodByDate/{date}") // /{date} is a PathVariable. The value of the PathVariable is assigned below, along with the data type (String) that it will be. The date is added manually when you type in the URL into a browser in this format: YYYY-MM-DD.
    public Object apodDateMod(@PathVariable(value = "date") String date, RestTemplate restTemplate) {
        return restTemplate.getForObject("https://api.nasa.gov/planetary/apod?api_key=" + env.getProperty("NASA_KEY") + "&date=" + date, Object.class);
    }
    
    @GetMapping("/pickFive")
    public Object pickFive(@RequestParam int count, RestTemplate restTemplate){
        return restTemplate.getForObject("https://api.nasa.gov/planetary/apod?api_key=" + env.getProperty("NASA_KEY") + "&count=" + count, Object.class);
    } // example link: http://localhost:8080/nasa/pickFive?count=7

    @GetMapping("/getPhotosInRange")
    public Object getPhotosInRange(@RequestParam String startDate, String endDate, RestTemplate restTemplate){
        return restTemplate.getForObject("https://api.nasa.gov/planetary/apod?api_key=" + env.getProperty("NASA_KEY") + "&start_date=" + startDate + "&end_date=" + endDate, Object.class);
    } // example link: http://localhost:8080/nasa/getPhotosInRange?startDate=2020-10-1&endDate=2020-11-17

}
