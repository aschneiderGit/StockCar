create table Voiture (
	id integer primary key auto_increment,	
	marque varchar(30) not null,
	modele varchar(30) not null,
	finition varchar(30) not null,
	carburant char,
	km integer,
	annee integer,
	prix integer
);