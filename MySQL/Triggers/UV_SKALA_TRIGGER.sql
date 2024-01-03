CREATE DEFINER=`root`@`localhost` TRIGGER `UV_SKALA_TRIGGER` BEFORE INSERT ON `uv_indeks_mjerenje` FOR EACH ROW BEGIN
	if(new.indeks>=0 && new.indeks<=2)then
set new.uv_indeks_skala_id=1;
elseif(new.indeks>=3 && new.indeks<=5)then
set new.uv_indeks_skala_id=2;
elseif(new.indeks>=6 && new.indeks<=7)then
set new.uv_indeks_skala_id=3;
elseif(new.indeks>=8 && new.indeks<=11)then
set new.uv_indeks_skala_id=4;
elseif(new.indeks>11)then
set new.uv_indeks_skala_id=5;
END IF;
END