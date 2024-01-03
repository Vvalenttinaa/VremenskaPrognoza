CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `db_vremenska_prognoza`.`uv_zracenje` AS
    SELECT 
        `g`.`naziv` AS `grad`,
        `skala`.`opis` AS `opasnost`,
        `skala`.`boja` AS `alarm`
    FROM
        ((((`db_vremenska_prognoza`.`grad` `g`
        JOIN `db_vremenska_prognoza`.`adresa` `a` ON ((`a`.`grad_id` = `g`.`id`)))
        JOIN `db_vremenska_prognoza`.`mjerenje` `m` ON ((`m`.`adresa_id` = `a`.`id`)))
        JOIN `db_vremenska_prognoza`.`uv_indeks_mjerenje` `uv` ON ((`uv`.`mjerenje_id` = `m`.`id_mjerenje`)))
        JOIN `db_vremenska_prognoza`.`uv_indeks_skala` `skala` ON ((`uv`.`uv_indeks_skala_id` = `skala`.`id`)))
    ORDER BY `skala`.`id`