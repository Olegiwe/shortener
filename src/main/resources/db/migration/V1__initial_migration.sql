create table link (
    id int8 not null,
    link varchar(255),
    short_link varchar(255),
    created_date date,
    primary key(id),
    unique (short_link)
);

create sequence seq_link_id increment by 1;


