package net.url.shortener.reader;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QList;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import net.url.shortener.dto.LinkDto;
import net.url.shortener.entity.QLink;
import net.url.shortener.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional(readOnly = true)
public class LinkReader {

    private static final QLink link = new QLink("link");

    @Autowired
    private LinkRepository linkRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public LinkDto getUrl(Long id) {
        return new JPAQuery<>(entityManager)
                .from(link)
                .where(link.id.eq(id))
                .select(Projections.constructor(LinkDto.class, link.id, link.link, link.shortLink))
                .fetchFirst();
    }


}
