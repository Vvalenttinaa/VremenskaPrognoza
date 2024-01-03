create view zaposleni_u_stanici(Ime, Prezime, Stanica) as
select z.ime, z.prezime,  concat(a.ulica, ', ' , a.broj, ', ', g.naziv, ', ', d.naziv)
from zaposleni z 
inner join meteoroloska_stanica s 
on s.id=z.meteoroloska_stanica_id
inner join adresa a on s.adresa_id=a.id
inner join grad g on a.grad_id=g.id
inner join drzava d on g.drzava_id=d.id;