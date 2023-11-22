create table user(
                user_id int not null auto_increment,
                user_name VARCHAR(60) not null,             #user name
                user_place VARCHAR(30),                     #user location
                user_bdate date not null,                   #user date of birth
                -- user_gender CHAR(1) not null,               #user gender
                user_email VARCHAR(30),                     #user email 
                primary key (user_id)
);

create table modalidade (
                        mod_id int not null auto_increment,
                        mod_name VARCHAR(30) not null,
                        primary key(mod_id)
);

create table campos (
                    camp_id int not null auto_increment,
                    camp_name VARCHAR(60) not null,         #campo name
                    camp_place VARCHAR(60),                 #campo address 
                    camp_num VARCHAR(14) not null,          #campo numero de tlm
                    camp_mod_id int,
                    primary key (camp_id)
);

create table modcamp(
                    modcamp_id int not null auto_increment,
                    modcamp_mod_id int not null,
                    modcamp_camp_id int not null,
                    primary key (modcamp_id)
);

create table mch(
                mch_id int not null auto_increment,
                mch_modcamp_id int not null,
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
                    res_estadoreserva_id int not null,
                    res_lob_id int not null,
                    primary key (res_id)

);

create table estadoreserva(
                        estadoreserva_id int not null auto_increment,
                        estadoreserva_name VARCHAR(30),
                        primary key (estadoreserva_id)
);

create table lobby(
                    lob_id int not null auto_increment,
                    lob_name VARCHAR(30),
                    lob_user_id int not null,
                    primary key (lob_id)
);

create table lobbyuser(
                    lobbyuser_id int not null auto_increment,
                    lobbyuser_user_id int not null,
                    lobbyuser_res_id int not null,
                    primary key (lobbyuser_id)
);

create table status(
                status_id int not null auto_increment,
                status_score int not null,
                status_name VARCHAR(30),
                primary key (status_id)
);

create table LUstatus(
                    LUstatus_id int not null auto_increment,
                    LUstatus_status_id int not null,
                    LUstatus_lobbyuser_id int not null,
                    primary key (LUstatus_id)
);

-- Foreign Keys --

alter table modcamp
add constraint modcamp_fk_modalidade
foreign key (modcamp_mod_id) references modalidade(mod_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table modcamp
add constraint modcamp_fk_campo
foreign key (modcamp_camp_id) references campos(camp_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table mch 
add constraint mch_fk_modcamp
foreign key (mch_modcamp_id) references modcamp(modcamp_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table mch 
add constraint mch_fk_horarios
foreign key (mch_modcamp_id) references horarios(hor_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table reserva 
add constraint reserva_fk_estadoreserva
foreign key (res_estadoreserva_id) references estadoreserva(estadoreserva_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table lobby
add constraint lobby_fk_user
foreign key (lob_user_id) references user(user_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;


alter table lobbyuser
add constraint lobbyuser_fk_user
foreign key (lobbyuser_user_id) references user(user_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;


alter table lobbyuser
add constraint lobbyuser_fk_reserva
foreign key (lobbyuser_res_id) references reserva(res_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;


alter table LUstatus
add constraint LUstatus_fk_status
foreign key (LUstatus_status_id) references status(status_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table LUstatus
add constraint LUstatus_fk_lobbysuer
foreign key (LUstatus_lobbyuser_id) references lobbyuser(lobbyuser_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;