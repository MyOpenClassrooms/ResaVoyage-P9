create table if not exists utilisateur
(
  idutilisateur serial not null
    constraint utilisateur_pkey
    primary key,
  email varchar not null,
  username varchar not null,
  password varchar not null,
  firstname varchar not null,
  lastname varchar not null,
  address varchar not null,
  postcode varchar not null,
  city varchar,
  phonenumber varchar not null,
  role varchar
);
