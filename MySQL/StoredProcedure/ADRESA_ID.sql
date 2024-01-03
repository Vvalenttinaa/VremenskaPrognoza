CREATE DEFINER=`root`@`localhost` PROCEDURE `ADRESA_ID`( in nazivDrzava varchar(45), in nazivGrad varchar(45), 
			in nazivUlica varchar(45), in brojUlica int, out adresaId int)
BEGIN
		select id from drzava where drzava.naziv=nazivDrzava into @idDrzava;
        select id from grad where grad.naziv=nazivGrad and grad.drzava_id=@idDrzava into @idGrad;
        select id from adresa where ulica=nazivUlica and broj=brojUlica and grad_id=@idGrad into adresaId;
END