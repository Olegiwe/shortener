package net.url.shortener.config;

import net.url.shortener.service.InitializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;

@Configuration
@Transactional
public class InitializationComponent implements ApplicationRunner {

    @Autowired
    private InitializationService initializationService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.initializationService.init();
    }
}
