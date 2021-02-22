package net.url.shortener.repository;

import net.url.shortener.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
    public Link findByLink(String link);
}
