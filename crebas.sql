/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     06/12/2019 10:54:28                          */
/*==============================================================*/


drop table if exists CHEF_RAYON;

drop table if exists CMD_EXTERNE;

drop table if exists CMD_INTERNE;

drop table if exists FOURNISSEUR;

drop table if exists LIGNE_CMD_IN;

drop table if exists LIGNE_EXTERNE;

drop table if exists PRODUIT;

drop table if exists RAYON;

/*==============================================================*/
/* Table: CHEF_RAYON                                            */
/*==============================================================*/
create table CHEF_RAYON
(
   ID_CHEF              int not null,
   ID_RAYON             int not null,
   NOM_CHEF             varchar(100),
   PRENOM_CHEF          varchar(100),
   CNI_CHEF             varchar(50),
   TEL_CHEF             varchar(20),
   primary key (ID_CHEF)
);

/*==============================================================*/
/* Table: CMD_EXTERNE                                           */
/*==============================================================*/
create table CMD_EXTERNE
(
   ID_CMD_EX            int not null,
   ID_CHEF              int not null,
   ID_FOURNISSEUR       int not null,
   DATE_CMD_EX          date,
   DATE_LIVRAISON       date,
   primary key (ID_CMD_EX)
);

/*==============================================================*/
/* Table: CMD_INTERNE                                           */
/*==============================================================*/
create table CMD_INTERNE
(
   ID_CMD_IN            int not null,
   ID_CHEF              int not null,
   DATE_CMD_IN          date,
   primary key (ID_CMD_IN)
);

/*==============================================================*/
/* Table: FOURNISSEUR                                           */
/*==============================================================*/
create table FOURNISSEUR
(
   ID_FOURNISSEUR       int not null,
   NOM_FOURNISSEUR      varchar(100),
   TEL_FOURNISSEUR      varchar(50),
   ADRESSE_FOURNISSEUR  varchar(100),
   primary key (ID_FOURNISSEUR)
);

/*==============================================================*/
/* Table: LIGNE_CMD_IN                                          */
/*==============================================================*/
create table LIGNE_CMD_IN
(
   ID_LIGNE_IN          int not null,
   ID_CMD_IN            int not null,
   ID_ARTICLE           int not null,
   QT_PRODUIT           int,
   primary key (ID_LIGNE_IN)
);

/*==============================================================*/
/* Table: LIGNE_EXTERNE                                         */
/*==============================================================*/
create table LIGNE_EXTERNE
(
   ID_LIGNE_EX          int not null,
   ID_CMD_EX            int not null,
   ID_ARTICLE           int not null,
   QT_PRODUIT           int,
   primary key (ID_LIGNE_EX)
);

/*==============================================================*/
/* Table: PRODUIT                                               */
/*==============================================================*/
create table PRODUIT
(
   ID_ARTICLE           int not null,
   NOM_PRODUIT          varchar(100),
   PRIX_VENTE           float,
   MARQUE               varchar(100),
   QTE_RAYON            int,
   QTE_DEPOT            int,
   primary key (ID_ARTICLE)
);

/*==============================================================*/
/* Table: RAYON                                                 */
/*==============================================================*/
create table RAYON
(
   ID_RAYON             int not null,
   NOM_RAYON            varchar(100),
   CAPACITE             int,
   primary key (ID_RAYON)
);

alter table CHEF_RAYON add constraint FK_GERE foreign key (ID_RAYON)
      references RAYON (ID_RAYON) on delete restrict on update restrict;

alter table CMD_EXTERNE add constraint FK_EFFECTUE foreign key (ID_CHEF)
      references CHEF_RAYON (ID_CHEF) on delete restrict on update restrict;

alter table CMD_EXTERNE add constraint FK_LIVRE foreign key (ID_FOURNISSEUR)
      references FOURNISSEUR (ID_FOURNISSEUR) on delete restrict on update restrict;

alter table CMD_INTERNE add constraint FK_FAIRE foreign key (ID_CHEF)
      references CHEF_RAYON (ID_CHEF) on delete restrict on update restrict;

alter table LIGNE_CMD_IN add constraint FK_COMPORTE foreign key (ID_CMD_IN)
      references CMD_INTERNE (ID_CMD_IN) on delete restrict on update restrict;

alter table LIGNE_CMD_IN add constraint FK_EST_COMPOSE_DE foreign key (ID_ARTICLE)
      references PRODUIT (ID_ARTICLE) on delete restrict on update restrict;

alter table LIGNE_EXTERNE add constraint FK_CONCERNE foreign key (ID_ARTICLE)
      references PRODUIT (ID_ARTICLE) on delete restrict on update restrict;

alter table LIGNE_EXTERNE add constraint FK_SE_COMPOSE foreign key (ID_CMD_EX)
      references CMD_EXTERNE (ID_CMD_EX) on delete restrict on update restrict;

