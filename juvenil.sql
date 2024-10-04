-- Ejercicio 1 Realiza un procedimiento llamado listadocuatromasprestados que nos muestre por pantalla un listado de los cuatro libros m�s prestados y los socios a los que han sido prestados con el siguiente formato:
CREATE OR ALTER PROCEDURE listadocuatromasprestados AS
BEGIN
	DECLARE @nPrestamos INT,
	@nombreLibro VARCHAR(30),
	@generoLibro VARCHAR(15),
	@ref VARCHAR(15),
	@dni VARCHAR(15),
	@fecha date

	DECLARE mycursor1 CURSOR FOR
	SELECT TOP 4 COUNT(p.RefLibro) AS prestamos, p.RefLibro, l.Nombre, l.genero FROM libros AS l
	JOIN prestamos AS p
	ON l.RefLibro=p.RefLibro
	GROUP BY l.Nombre, l.genero, p.RefLibro
	ORDER BY COUNT(p.RefLibro) desc

	OPEN mycursor1
		FETCH mycursor1 into @nPrestamos, @ref, @nombreLibro, @generoLibro
		WHILE(@@FETCH_STATUS = 0)
		BEGIN
			DECLARE mycursor2 CURSOR FOR
			SELECT Dni, FechaPrestamo FROM prestamos
			WHERE RefLibro=@ref
			
			PRINT ('------------------------------')
			PRINT CONCAT(@nombreLibro, ' ', @nPrestamos, ' ', @generoLibro)

			OPEN mycursor2
			FETCH mycursor2 into @dni, @fecha
			WHILE(@@FETCH_STATUS = 0)
			BEGIN
				print CONCAT(' ', @dni, ' ', @fecha)
				FETCH mycursor2 into @dni, @fecha
			END

			CLOSE mycursor2
			DEALLOCATE mycursor2

			FETCH mycursor1 into @nPrestamos, @ref, @nombreLibro, @generoLibro

		END
	CLOSE mycursor1
	DEALLOCATE mycursor1
	
END

EXEC listadocuatromasprestados

-- Ejercicio 2 Dise�a un procedimiento al que pasemos como par�metro de entrada el nombre de uno de los m�dulos existentes en la BD y visualice el nombre de los alumnos que lo han cursado junto a su nota.
--Al final del listado debe aparecer el n� de suspensos, aprobados, notables y sobresalientes.
--Asimismo, deben aparecer al final los nombres y notas de los alumnos que tengan la nota m�s alta y la m�s baja.
--Debes comprobar que las tablas tengan almacenada informaci�n y que exista el m�dulo cuyo nombre pasamos como par�metro al procedimiento.
CREATE OR ALTER PROCEDURE listadoAlumnos (@nombre varchar(20)) AS
BEGIN
	DECLARE @alumno VARCHAR(30),
	@nota int,
	@suspensos int,
	@aprobados int,
	@notables int,
	@sobresalientes int

	DECLARE mycursor CURSOR FOR
	SELECT 

END

EXEC listadoAlumnos
