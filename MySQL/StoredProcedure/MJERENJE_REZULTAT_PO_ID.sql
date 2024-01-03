CREATE DEFINER=`root`@`localhost` PROCEDURE `MJERENJE_REZULTAT_PO_ID`( IN id_mjerenje_in INT ,
	out temperaturaOut INT,
    out uvOpisOut varchar(45),
    out uvBojaOut varchar(45),
    out padavineNazivOut varchar(45),
    out padavineKolicinaOut INT,
    out padavineOpisOut varchar(45),
    out padavineVjerovatnocaOut INT 
    )
BEGIN

	declare mjerenjeId INT;
	select id_mjerenje from mjerenje where id_mjerenje=id_mjerenje_in
    into @mjerenjeId;
    
    
	select vrijednost from temperatura where mjerenje_id=@mjerenjeId into temperaturaOut;
    
    select uv_indeks_skala_id from uv_indeks_mjerenje where mjerenje_id=@mjerenjeId into @uvId;
    select opis from uv_indeks_skala where uv_indeks_skala.id=@uvId into uvOpisOut;
	select boja from uv_indeks_skala where uv_indeks_skala.id=@uvId into uvBojaOut;
    
    select padavine_id from padavine_mjerenje where mjerenje_id=@mjerenjeId into @padavineNazivId;
    select naziv from padavine where padavine.id=@padavineNazivId into padavineNazivOut;
    select opis from padavine_mjerenje where padavine_mjerenje.mjerenje_id=@mjerenjeId into padavineOpisOut;
    select kolicina from padavine_mjerenje where padavine_mjerenje.mjerenje_id=@mjerenjeId into padavineKolicinaOut;
    select vjerovatnoca from padavine_mjerenje where padavine_mjerenje.mjerenje_id=@mjerenjeId into padavineVjerovatnocaOut;
	
END