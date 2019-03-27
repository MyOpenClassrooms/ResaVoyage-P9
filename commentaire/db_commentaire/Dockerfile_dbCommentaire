FROM postgres:10.5-alpine

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=0302
ENV POSTGRES_DB=db_commentaire

COPY init/db/docker-entrypoint-initdb.d/* /docker-entrypoint-initdb.d/ 