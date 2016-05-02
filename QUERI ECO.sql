SELECT * 
FROM producto 
WHERE nombre LIKE "%THERMOS%" AND fkMarca = 9999

UPDATE producto SET fkMarca = 51 WHERE nombre LIKE "%THERMOS%" AND fkMarca = 9999

SELECT * 
FROM producto 
WHERE fkMarca = 9999