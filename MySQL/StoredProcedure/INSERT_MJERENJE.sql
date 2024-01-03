DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERT_MJERENJE`(IN zaposleni_osoba_id INT, 
IN adresa_id INT, IN lokacija_instrumenata_id INT, IN temperatura INT, IN uv_indeks INT, 
IN opis_padavine VARCHAR(45), IN kolicina_padavine INT, IN vjerovatnoca_padavine INT, 
IN padavine_tip INT, IN vrijeme TIMESTAMP )
BEGIN

	insert into mjerenje (zaposleni_osoba_id, adresa_id, lokacija_instrumenata_id, vrijeme_mjerenja)
    values (zaposleni_osoba_id, adresa_id, lokacija_instrumenata_id, vrijeme);
	insert into temperatura(vrijednost, mjerenje_id) values (temperatura, last_insert_id());
    insert into uv_indeks_mjerenje(indeks, mjerenje_id) values (uv_indeks, last_insert_id());
    insert into padavine_mjerenje(mjerenje_id, padavine_id, opis, vjerovatnoca, kolicina) values
				(last_insert_id(), padavine_tip, opis_padavine, vjerovatnoca_padavine, kolicina_padavine);
    
END $$
DELIMITER ;