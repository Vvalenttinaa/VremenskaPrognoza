CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `db_vremenska_prognoza`.`temperature_u_gradovima` AS
    SELECT 
        `t`.`vrijednost` AS `vrijednost`, `g`.`naziv` AS `naziv`
    FROM
        (((`db_vremenska_prognoza`.`temperatura` `t`
        JOIN `db_vremenska_prognoza`.`mjerenje` `m` ON ((`m`.`id_mjerenje` = `t`.`mjerenje_id`)))
        JOIN `db_vremenska_prognoza`.`adresa` `a` ON ((`m`.`adresa_id` = `a`.`id`)))
        JOIN `db_vremenska_prognoza`.`grad` `g` ON ((`g`.`id` = `a`.`grad_id`)))