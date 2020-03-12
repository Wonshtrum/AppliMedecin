
DROP DATABASE projetgi;
CREATE DATABASE IF NOT EXISTS projetgi;
USE projetgi;

CREATE TABLE client
(
	id_client INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	type_offre SMALLINT	,/*#Type d’offre : remplacement – succession – collaboration - installation*/
	mail VARCHAR(255) ,/*#Mail*/
	num_tel VARCHAR(10) ,/*#Numéro de téléphone*/
	adresse VARCHAR(255) ,/*#Adresse*/
	periode VARCHAR(255),/* #Période souhaitée : calendrier*/
	zone_geo VARCHAR(255), /*#Zone géographique : Km max, géo-référencement*/
	km_max INT
);

CREATE TABLE remplacant
(
	id_remplacant INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	mail VARCHAR(255) ,/*#Mail*/
	num_tel VARCHAR(10) ,/*#Numéro de téléphone*/
	dispo VARCHAR(255),/* #Disponibilités : calendrier*/
	zone_geo VARCHAR(255),/* #Zone géographique : Km max, géo-référencement*/
	km_max INT,
	spec VARCHAR(255) ,/*#Spécialité (outre la médecine générale ; par exemple : sport, sommeil, gynécologie, etc.)*/
	description VARCHAR(4095) ,/*#Zone libre : description du profil*/
	cv_filename VARCHAR(255),/* #Nom du fichier CV*/
	carte_pro_filename VARCHAR(255)/*#Nom du fichier carte professionnelle*/
);

CREATE TABLE offre
(
	id_offre INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	id_client INT NOT NULL,
	type_offre SMALLINT ,/*Type d’offre : remplacement – succession – collaboration - installation*/
	visite_domicile INT ,/*#Visite à domicile (oui/non) : si oui, indiquer la rayonnement (Km)*/
	activite BOOLEAN ,/*#Activité : seule ou en association*/
	horaire VARCHAR(255) ,/*#Horaires – Jours travaillés*/
	logiciel_utilise VARCHAR(255) ,/*#Logiciel utilisé*/
	retrocession VARCHAR(255) ,/*#Rétrocession (rémunération) : Pourcentage à définir*/
	secretariat BOOLEAN,/* #Secrétariat(oui/non) :sioui,indiquer :s’ils’agitd’unesecrétariatphysiqueouàdistance(téléphonique) ; disponibilité du secrétariat (heures travaillées, jours)*/
	dispo_sec VARCHAR(255),
	type_patient VARCHAR(255) ,/*#Type de patientèle (dominante : personnes âgées, enfants, Non communiquée)*/
	spec VARCHAR(255) ,/*#Typed’activité :spécialité(outrelamédecinegénérale ;parexemple :sport,sommeil,gynécologie, etc.)*/
	description VARCHAR(4096) ,/*#Zonelibre :descriptiondesconditionsdetravail ;avantagescomplémentaires(parexemple:10C assurés ; condition de travail ; logement ; etc.)*/
	carte_pro_filename VARCHAR(255),/*#Nom du fichier carte professionnelle*/
    CONSTRAINT FK_id_client FOREIGN KEY (id_client) REFERENCES client(id_client)
);

CREATE TABLE postulat
(
	id_postulat INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	id_remplacant INT NOT NULL,
	id_offre INT NOT NULL,
    CONSTRAINT FK_id_remplacent FOREIGN KEY (id_remplacant) REFERENCES remplacant(id_remplacant),
    CONSTRAINT FK_id_offre FOREIGN KEY (id_offre) REFERENCES offre(id_offre)
);
