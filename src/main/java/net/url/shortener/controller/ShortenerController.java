package net.url.shortener.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/shortener")
public class ShortenerController {

    @GetMapping("/test")
    public String test() {
        return "<h1>HELLO IDIOTS!</h1>";
    }
}
