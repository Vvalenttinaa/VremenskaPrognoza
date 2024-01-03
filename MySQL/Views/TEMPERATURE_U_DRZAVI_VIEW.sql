CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `db_vremenska_prognoza`.`temperature_u_drzavi` AS
    SELECT 
        `d`.`naziv` AS `drzava`,
        `g`.`naziv` AS `grad`,
        `t`.`vrijednost` AS `temperatura`
    FROM
        ((((`db_vremenska_prognoza`.`drzava` `d`
        JOIN `db_vremenska_prognoza`.`grad` `g` ON ((`d`.`id` = `g`.`drzava_id`)))
        JOIN `db_vremenska_prognoza`.`adresa` `a` ON ((`a`.`grad_id` = `g`.`id`)))
        JOIN `db_vremenska_prognoza`.`mjerenje` `m` ON ((`m`.`adresa_id` = `a`.`id`)))
        JOIN `db_vremenska_prognoza`.`temperatura` `t` ON ((`t`.`mjerenje_id` = `m`.`id_mjerenje`)))
    ORDER BY `d`.`naziv`