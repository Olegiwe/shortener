package net.url.shortener.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "link_id_generator")
    @SequenceGenerator(name = "link_id_generator", sequenceName = "link_id_seq")
    private Long id;
    private String link;
    private String shortLink;
    private LocalDateTime createdDate;

}
