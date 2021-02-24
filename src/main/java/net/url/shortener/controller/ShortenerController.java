package net.url.shortener.controller;

import net.url.shortener.dto.LinkDto;
import net.url.shortener.entity.Link;
import net.url.shortener.reader.LinkReader;
import net.url.shortener.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("shortener")
public class ShortenerController {

    @Autowired
    private LinkService linkService;

    @Autowired
    private LinkReader linkReader;

    @Autowired
    private Environment environment;

    @GetMapping("test")
    public String test() {
        return "<h1>HELLO IDIOTS!</h1>";
    }

    @GetMapping("all")
    public List<LinkDto> getAllLinks() {
        return this.linkReader.getAllLinks();
    }

    @GetMapping("link")
    public String getLink() {
        return InetAddress.getLoopbackAddress().getHostAddress()
                + ":" + environment.getProperty("server.port")
                + "/" + linkService.generateShortLink();
    }

    @PostMapping("new")
    public LinkDto postNewLink(@RequestBody LinkDto linkDto) {
        Link link = linkService.createLink(linkDto);
        return linkReader.getLink(link.getId());
    }
}
