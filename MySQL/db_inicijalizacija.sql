use db_vremenska_prognoza;

insert into nalog values (1, 'lozinka', 'Marko', 'A');
insert into nalog values (2, 'lozinka', 'Janko', 'M');


insert into drzava values (1, 'Bosna i Hercegovina');
insert into drzava(naziv) values('Srbija');

insert into grad values (1, 'Banja Luka', 1);

insert into adresa values (1, 'Majke Jugovica', 1, 1);
insert into adresa values (2, 'Majke Jugovica', 5, 1);
insert into adresa values (3, 'Carice Milice', 1, 1);

insert into meteoroloska_stanica values (1,1);

insert into lokacija_instrumenata values (1,3,1);

insert into nalog values(1,'lozinka', 'Marko', 'A');
insert into nalog values(2, 'lozinka', 'Janko', 'M');

insert into zaposleni values (1, 'Marko', 'Markovic', 1, 1);
insert into zaposleni values (2, 'Janko', 'Jankovic', 1, 2);

insert into zaposleni values (1, 'Marko' , 'Markovic', 1, 1);

insert into padavine values(1, 'Kisa');
insert into padavine values(2, 'Snijeg');
insert into padavine values(3, 'Susnjezica');

insert into uv_indeks_skala values (1, 'Niska opasnost', 0,2, 'Zelena');
insert into uv_indeks_skala values (2, 'Srednji rizik', 3,5, 'Zuta');
insert into uv_indeks_skala values (3, 'Visoki rizik', 6,7, 'Narandzasta');
insert into uv_indeks_skala values (4, 'Vrlo visoki rizik', 8,11, 'Crvena');
insert into uv_indeks_skala values (5, 'Ekstremni rizik', 11,100, 'Plava');

insert into alergija_naziv values (1,'Polen');
insert into alergija_naziv (naziv) values ('Ambrozija');

insert into alergija_skala values (1, 'Niska' , 1,3,1);
insert into alergija_skala values (2, 'Visoka' , 4,7,1);

insert into alergija_skala values (3, 'Niska' , 1,3,2);
insert into alergija_skala values (4, 'Visoka' , 4,7,2);

insert into alergija_mjerenje values (1, 1, 1);

insert into alarm(boja) value ('zuta');
insert into alarm(boja) value ('narandzasta');
insert into alarm(boja) value ('crvena');

insert into vjetar value (1,'Kosava');
insert into vjetar value (2, 'Bura');

insert into vjetar_mjerenje(jacina_udara, pravac, opis, vjetar_id, mjerenje_id) values
(6, 'j', 'Vjetar donosi povremene toplotne talase.', 1, 2);
insert into vjetar_mjerenje(jacina_udara, pravac, vjetar_id, mjerenje_id) values
(12, 's', 2, 1);


