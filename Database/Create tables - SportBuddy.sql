create table cliente(
                cli _id int not null auto_increment,
                cli_name VARCHAR(60) not null,             #cliente name
                cli_place VARCHAR(30),                     #cliente location
                cli_bdate date not null,                   #cliente date of birth
                cli_gender CHAR(1) not null,               #cliente gender
                cli_email VARCHAR(30),                     #cliente email 
                primary key (cli_id)
);

create table modalidade(
                        mod_id int not null auto_increment,
                        mod_name VARCHAR(30) not null,
                        primary key(mod_id)
);

create table campos(
                    camp_id int not null auto_increment,
                    camp_name VARCHAR(60) not null,         #campo name
                    camp_place VARCHAR(60),                 #campo address 
                    camp_num VARCHAR(14) not null,          #campo numero de tlm
                    camp_mod_id int,
                    primary key (camp_id)
);

create table MC(
                mc_id int not null auto_increment,
                mc_mod_id int not null,
                mc_camp_id int not null,
                primary key (mc_id)
);

create table MCH(
                mch_id int not null auto_increment,
                mch_mc_id int not null,
                mch_hor_id int not null,
                primary key (mch_id)
);

create table horarios(
                    hor_id int not null auto_increment,
                    hor_slot datetime,                      -- slot marcando o dia/hora da marcação
                    primary key (hor_id)
);

create table reserva(
                    res_id int not null auto_increment,
                    res_estado VARCHAR(20),
                    res_pdate datetime not null,
                    res_er_id int not null,
                    res_lob_id int not null,
                    primary key (res_id)

);

create table ER(
                er_id int not null auto_increment,
                er_name VARCHAR(30) not null,
                primary key (er_id)
);

create table lobby(
                    lob_id int not null auto_increment,
                    lob_name VARCHAR(30),
                    lob_cliente_id int not null,
                    primary key (lob_id)
);

create table LU(
                lu_id int not null auto_increment,
                lu_cli_id int not null,
                lu_res_id int not null,
                primary key (lu_id)
);

create table creditscore(
                cs_id int not null auto_increment,
                cs_score int not null,
                cs_name VARCHAR(30),
                primary key (cs_id) 
);

create table LUC(
                luc_id int not null auto_increment,
                luc_cs_id int not null,
                luc_lu_id int not null,
                primary key (luc_id)
);

-- Foreign Keys --

alter table mc
add constraint mc_fk_modalidade
foreign key (mc_mod_id) references modalidade(mod_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table mc
add constraint mc_fk_campo
foreign key (mc_camp_id) references campos(camp_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table mch 
add constraint mch_fk_mc
foreign key (mch_mc_id) references mc(mc_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table mch 
add constraint mch_fk_horarios
foreign key (mch_mc_id) references horarios(hor_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table reserva 
add constraint reserva_fk_er
foreign key (res_er_id) references er(er_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table lobby
add constraint lobby_fk_cliente
foreign key (lob_cliente_id) references cliente(cli_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table lu
add constraint lu_fk_cliente
foreign key (lu_cliente_id) references cliente(cli_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table lu
add constraint lu_fk_reserva
foreign key (lu_res_id) references reserva(res_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table luc
add constraint luc_fk_creditscore
foreign key (luc_cs_id) references creditscore(cs_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table luc
add constraint luc_fk_lu
foreign key (luc_lu_id) references lu(lu_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;