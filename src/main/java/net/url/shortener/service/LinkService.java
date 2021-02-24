package net.url.shortener.service;

import net.url.shortener.dto.LinkDto;
import net.url.shortener.entity.Link;
import net.url.shortener.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;
import java.util.Random;

@Service
public class LinkService {

    private static final long LOWER_BOUNDARY = 128L * 1024 * 1024 * 1024 * 1024; // 2^47
    private static final long UPPER_BOUNDARY = 256L * 1024 * 1024 * 1024 * 1024 - 1; // 2^48 -1
    private static final int BYTE_ARRAY_SIZE = 6; // Base64: 6 bits -> 1 char, so 8 chars - 48 bits - 6 bytes

    private final Random random = new Random();


    @Autowired
    private LinkRepository linkRepository;


    public String generateShortLink() {
        byte[] bytes = new byte[BYTE_ARRAY_SIZE];
        long number = (random.nextLong() % (UPPER_BOUNDARY - LOWER_BOUNDARY)) + LOWER_BOUNDARY;
        for (int i = 0; i < BYTE_ARRAY_SIZE; i++) {
            byte temp_byte = (byte) ((number >> 48 - 8 * (1 + i)) & 63);
            bytes[i] = (temp_byte >> 1 == 31 ? 0 : temp_byte);
        }
        String code = Base64.getEncoder().encodeToString(bytes);
        Arrays.fill(bytes, (byte) 0);
        return code;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Link createLink(LinkDto dto) {
        if (dto.getFullLink() == null)
            throw new RuntimeException("No full link provided");
        String generatedLink;
        do {
            generatedLink = generateShortLink();
        } while (linkRepository.findByShortLink(generatedLink) == null);
        return linkRepository.save(new Link(dto.getFullLink(), generatedLink));
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public Link createLink(String fullLink) {
        String generatedLink;
        do {
            generatedLink = generateShortLink();
        } while (linkRepository.findByShortLink(generatedLink) == null);
        return linkRepository.save(new Link(fullLink, generatedLink));
    }

}
