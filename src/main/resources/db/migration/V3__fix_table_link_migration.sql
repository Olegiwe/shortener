alter table shortener.link rename column link to full_link;

alter table shortener.link rename column created_date to created_date_time;
alter table shortener.link alter column created_date_time type timestamp;

