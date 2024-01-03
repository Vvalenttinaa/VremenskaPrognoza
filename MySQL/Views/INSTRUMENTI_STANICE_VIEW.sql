CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = `root`@`localhost` 
    SQL SECURITY DEFINER
VIEW `db_vremenska_prognoza`.`instrumenti_stanice` AS
    SELECT 
        `a`.`ulica` AS `ulica`,
        `a`.`broj` AS `broj`,
        `g`.`naziv` AS `grad`,
        `d`.`naziv` AS `drzava`,
        `li`.`id` AS `id`,
        `li`.`meteoroloska_stanica_id` AS `id_stanice`
    FROM
        ((((`db_vremenska_prognoza`.`meteoroloska_stanica` `stanica`
        JOIN `db_vremenska_prognoza`.`lokacija_instrumenata` `li` ON ((`stanica`.`id` = `li`.`meteoroloska_stanica_id`)))
        JOIN `db_vremenska_prognoza`.`adresa` `a` ON ((`a`.`id` = `li`.`adresa_id`)))
        JOIN `db_vremenska_prognoza`.`grad` `g` ON ((`g`.`id` = `a`.`grad_id`)))
        JOIN `db_vremenska_prognoza`.`drzava` `d` ON ((`d`.`id` = `g`.`drzava_id`)))