
CREATE TABLE db_commande.commande(
   command_id SERIAL NOT NULL,
   user_id Integer NOT NULL,
   session_id Integer NOT NULL, 
   date DATE  NOT NULL,
   status BOOLEAN NOT NULL,     
   PRIMARY KEY (command_id)
);

