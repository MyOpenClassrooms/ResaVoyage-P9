CREATE TABLE db_commentaire.commentaire (
    idcommentaire SERIAL NOT NULL,
    date timestamp(4) without time zone NOT NULL,
    content text NOT NULL,
    idutilisateur integer,
    idaventure integer NOT NULL
);