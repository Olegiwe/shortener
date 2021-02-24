package net.url.shortener.service;


import net.url.shortener.entity.Link;
import net.url.shortener.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InitializationService {

    @Autowired
    private LinkRepository linkRepository;


    public void init() {
        System.out.println("Initialization service invoked!");
        if (linkRepository.findAllByFullLink("https://www.baeldung.com/running-setup-logic-on-startup-in-spring").isEmpty()) {
            linkRepository.save(new Link("https://www.baeldung.com/running-setup-logic-on-startup-in-spring", "INIT"));
        }
    }
}
