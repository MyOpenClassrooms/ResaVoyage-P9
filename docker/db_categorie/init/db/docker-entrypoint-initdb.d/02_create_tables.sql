create table categorie.categorie
(
  id          integer not null
    constraint categorie_pkey
    primary key,
  title       varchar not null,
  description varchar not null,
  image       varchar,
  keywords    varchar
);
