/*==============================================================*/
/* Nom de SGBD :  PostgreSQL 8                                  */
/* Date de création :  01/11/2024 15:47:20                      */
/*==============================================================*/

drop table if exists GROUPE cascade;
drop table if exists SPECIALITE cascade;

/*==============================================================*/
/* Table : GROUPE                                               */
/*==============================================================*/
create table GROUPE (
   ID                   INT4                 not null,
   NOM                  VARCHAR(100)         null,
   constraint GROUPE_pkey primary key (ID)
);

insert into GROUPE (ID, NOM) values (1, 'Anesthésie');
insert into GROUPE (ID, NOM) values (2, 'Oncologie clinique');
insert into GROUPE (ID, NOM) values (3, 'Groupe dentaire');
insert into GROUPE (ID, NOM) values (4, 'Médecine d’urgence');
insert into GROUPE (ID, NOM) values (5, 'Groupe de médecine générale');
insert into GROUPE (ID, NOM) values (6, 'Obstétrique et gynécologie');
insert into GROUPE (ID, NOM) values (7, 'Groupe pédiatrique');
insert into GROUPE (ID, NOM) values (8, 'Groupe de pathologie');
insert into GROUPE (ID, NOM) values (9, 'Groupe pronostics et gestion de santé/santé communautaire');
insert into GROUPE (ID, NOM) values (10, 'Groupe de psychiatrie');
insert into GROUPE (ID, NOM) values (11, 'Groupe de radiologie');
insert into GROUPE (ID, NOM) values (12, 'Groupe chirurgical');

/*==============================================================*/
/* Table : SPECIALITE                                           */
/*==============================================================*/
create table SPECIALITE (
   ID                   INT4                 not null,
   GROUPE_ID            INT4                 null,
   NOM                  VARCHAR(100)         null,
   constraint SPECIALITE_pkey primary key (ID)
);

insert into SPECIALITE (ID, GROUPE_ID, NOM) values (1, 1, 'Anesthésie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (2, 1, 'Soins intensifs');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (3, 2, 'Oncologie clinique');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (4, 3, 'Spécialités dentaires supplémentaires');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (5, 3, 'Radiologie dentaire et maxillo-faciale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (6, 3, 'Endodontie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (7, 3, 'Chirurgie buccale et maxillo-faciale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (8, 3, 'Pathologie buccale et maxillo-faciale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (9, 3, 'Médecine buccale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (10, 3, 'Chirurgie buccale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (11, 3, 'Orthodontie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (12, 3, 'Dentisterie pédiatrique');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (13, 3, 'Parodontie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (14, 3, 'Prosthodontie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (15, 3, 'Dentisterie restauratrice');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (16, 3, 'Dentisterie de soins spéciaux');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (17, 4, 'Médecine d’urgence');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (18, 5, 'Médecine interne de soins aigus');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (19, 5, 'Allergie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (20, 5, 'Médecine audiovestibulaire');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (21, 5, 'Cardiologie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (22, 5, 'Génétique clinique');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (23, 5, 'Neurophysiologie clinique');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (24, 5, 'Pharmacologie clinique et thérapeuthique');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (25, 5, 'Dermatologie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (26, 5, 'Endocrinologie et diabète sucré');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (27, 5, 'Gastroentérologie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (28, 5, 'Médecine générale (interne)');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (29, 5, 'Médecine générale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (30, 5, 'Médecine générale (GP) 6 mois');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (31, 5, 'Médecine génito-urinaire');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (32, 5, 'Médecine gériatrique');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (33, 5, 'Maladies infectieuses');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (34, 5, 'Oncologie médicale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (35, 5, 'Ophtalmologie médicale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (36, 5, 'Neurologie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (37, 5, 'Médecine du travail');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (38, 5, 'Autre');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (39, 5, 'Médecine palliative');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (40, 5, 'Médecine de réadaptation');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (41, 5, 'Médecine rénale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (42, 5, 'Médecine respiratoire');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (43, 5, 'Rhumatologie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (44, 5, 'Médecine du sport et de l’exercice');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (45, 6, 'Santé publique sexuelle et procréative');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (46, 7, 'Cardiologie pédiatrique');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (47, 7, 'Pédiatrie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (48, 8, 'Pathologie chimique');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (49, 8, 'Neurophathologie diagnostique');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (50, 8, 'Histopathologie médico-légale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (51, 8, 'Pathologie générale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (52, 8, 'Hématologie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (53, 8, 'Histopathologie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (54, 8, 'Immunologie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (55, 8, 'Microbiologie médicale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (56, 8, 'Pathologie pédiatrique et périnatale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (57, 8, 'Virologie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (58, 9, 'Service de santé communautaire dentaire');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (59, 9, 'Service de santé communautaire médicale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (60, 9, 'Santé publique dentaire');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (61, 9, 'Pratique de l’art dentaire');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (62, 9, 'Santé publique');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (63, 10, 'Psychiatrie infantile et adolescente');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (64, 10, 'Psychiatrie légale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (65, 10, 'Psychiatrie générale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (66, 10, 'Psychiatrie de la vieillesse');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (67, 10, 'Psychiatrie des troubles d’apprentissage');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (68, 10, 'Psychothérapie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (69, 11, 'Radiologie clinique');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (70, 11, 'Médecine nucléaire');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (71, 12, 'Chirurgie cardiothoracique');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (72, 12, 'Chirurgie générale');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (73, 12, 'Neurochirurgie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (74, 12, 'Ophtalmologie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (75, 12, 'Otolaryngologie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (76, 12, 'Chirurgie pédiatrique');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (77, 12, 'Chirurgie plastique');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (78, 12, 'Traumatologie et chirurgie orthopédique');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (79, 12, 'Urologie');
insert into SPECIALITE (ID, GROUPE_ID, NOM) values (80, 12, 'Chirurgie vasculaire');

alter table SPECIALITE
   add constraint FK_SPECIALI_REFERENCE_GROUPE foreign key (GROUPE_ID)
      references GROUPE (ID)
      on delete restrict on update restrict;