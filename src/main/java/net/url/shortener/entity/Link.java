package net.url.shortener.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "link_id_generator")
    @SequenceGenerator(name = "link_id_generator", sequenceName = "seq_link_id")
    private Long id;
    private String link;
    @Column(unique = true)
    private String shortLink;
    private LocalDateTime createdDate;

}
