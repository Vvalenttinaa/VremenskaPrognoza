CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `db_vremenska_prognoza`.`alergije_u_gradu` (`Grad` , `Alergija` , `Opasnost`) AS
    SELECT 
        `g`.`naziv` AS `naziv`,
        `aln`.`naziv` AS `naziv`,
        `s`.`opasnost` AS `opasnost`
    FROM
        (((((`db_vremenska_prognoza`.`alergija_mjerenje` `alm`
        JOIN `db_vremenska_prognoza`.`mjerenje` `m` ON ((`m`.`id_mjerenje` = `alm`.`mjerenje_id`)))
        JOIN `db_vremenska_prognoza`.`adresa` `a` ON ((`m`.`adresa_id` = `a`.`id`)))
        JOIN `db_vremenska_prognoza`.`grad` `g` ON ((`g`.`id` = `a`.`grad_id`)))
        JOIN `db_vremenska_prognoza`.`alergija_naziv` `aln` ON ((`alm`.`alergija_naziv_id` = `aln`.`id`)))
        JOIN `db_vremenska_prognoza`.`alergija_skala` `s` ON ((`s`.`alergija_naziv_id` = `aln`.`id`)))