create table aventure_session.aventure
(
  id            SERIAL not null
    constraint aventure_pkey
    primary key,
  description   varchar not null,
  location      varchar not null,
  nbparticipant integer not null,
  price         integer not null,
  title         varchar not null,
  image         varchar,
  category_id   integer
);


create table aventure_session.session
(
  id          SERIAL not null
    constraint session_pkey
    primary key,
  startdate   date    not null,
  enddate     date    not null,
  aventure_id integer not null
    constraint session_aventure_id_fk
    references aventure
);