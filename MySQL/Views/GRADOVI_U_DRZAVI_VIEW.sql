CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `db_vremenska_prognoza`.`gradovi_u_drzavi` AS
    SELECT 
        `g`.`naziv` AS `naziv`, `g`.`drzava_id` AS `id`
    FROM
        (`db_vremenska_prognoza`.`grad` `g`
        JOIN `db_vremenska_prognoza`.`drzava` `d` ON ((`d`.`id` = `g`.`drzava_id`)))