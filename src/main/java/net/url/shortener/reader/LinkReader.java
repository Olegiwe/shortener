package net.url.shortener.reader;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import net.url.shortener.dto.LinkDto;
import net.url.shortener.entity.QLink;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class LinkReader {

    private static final QLink link = new QLink("link");

    @PersistenceContext
    private EntityManager entityManager;

    public LinkDto getLink(Long id) {
        return new JPAQuery<>(entityManager)
                .from(link)
                .where(link.id.eq(id))
                .select(Projections.bean(LinkDto.class, link.id, link.link, link.shortLink))
                .fetchFirst();
    }

    public List<LinkDto> getAllLinks() {
        return new JPAQuery<>(entityManager)
                .from(link)
                .select(Projections.bean(LinkDto.class, link.id, link.link, link.shortLink))
                .fetch();
    }


}
