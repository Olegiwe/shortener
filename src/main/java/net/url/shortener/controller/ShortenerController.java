package net.url.shortener.controller;

import net.url.shortener.entity.Link;
import net.url.shortener.repository.LinkRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("shortener")
public class ShortenerController {

    @GetMapping("test")
    public String test() {
        return "<h1>HELLO IDIOTS!</h1>";
    }
/*
    public List<Link> getAllLinks () {

    }*/
}
