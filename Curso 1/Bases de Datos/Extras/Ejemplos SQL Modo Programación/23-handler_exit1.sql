/*Ejemplo de uso de manejadores.*/
use curso;
DROP PROCEDURE IF EXISTS handler_exit1;
DELIMITER //
CREATE PROCEDURE handler_exit1 (id int, nombre varchar(14), localidad varchar(10)) modifies sql data 
BEGIN  
	DECLARE clave_repetida tinyint default 0;
    BEGIN
		DECLARE EXIT HANDLER FOR 1062
			set clave_repetida = 1;
		insert into departamentos values(id, nombre, localidad); 
        select concat ('Registro dado de alta: ', id, ' - ', nombre, ' - ', localidad) as 'Inserción';
    
    END;
    if clave_repetida = 1 then
		select concat('Id dpto ', id, ' ya existe') as 'Aviso de error';
    end if;
	
END //
DELIMITER ;
call handler_exit1(10,'Otro', 'Madrid');
call handler_exit1(150,'Otro', 'Madrid');