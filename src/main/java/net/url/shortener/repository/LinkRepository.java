package net.url.shortener.repository;

import net.url.shortener.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Long> {
    public Link findByShortLink(String shortLink);

    public List<Link> findAllByLink (String link);
}

