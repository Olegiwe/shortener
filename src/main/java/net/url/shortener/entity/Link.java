package net.url.shortener.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.url.shortener.dto.LinkDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
@Data
@NoArgsConstructor
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "link_id_generator")
    @SequenceGenerator(name = "link_id_generator", sequenceName = "seq_link_id", allocationSize = 1)
    private Long id;
    private String fullLink;
    @Column(unique = true)
    private String shortLink;
    private LocalDateTime createdDateTime;
    private Long lifespan;
    private Boolean isExpired;

    public Link(String link, String shortLink) {
        this.fullLink = link;
        this.shortLink = shortLink;
        this.createdDateTime = LocalDateTime.now();
        this.lifespan = -1L; // infinite
        this.isExpired = false;
    }

}
