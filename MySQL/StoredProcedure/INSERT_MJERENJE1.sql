CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERT_MJERENJE1`(IN zaposleni_osoba_id INT, 
IN adresa_id INT, IN lokacija_instrumenata_id INT, IN temperatura INT, IN uv_indeks INT,
IN vrijeme TIMESTAMP)
BEGIN
insert into mjerenje (zaposleni_osoba_id, adresa_id, lokacija_instrumenata_id, vrijeme_mjerenja)
    values (zaposleni_osoba_id, adresa_id, lokacija_instrumenata_id, vrijeme);
	insert into temperatura(vrijednost, mjerenje_id) values (temperatura, last_insert_id());
    insert into uv_indeks_mjerenje(indeks, mjerenje_id) values (uv_indeks, last_insert_id());
    
END