-- Ejercicio 1 Realiza un procedimiento llamado listadocuatromasprestados que nos muestre por pantalla un listado de los cuatro libros más prestados y los socios a los que han sido prestados con el siguiente formato:
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

-- Ejercicio 2 Diseña un procedimiento al que pasemos como parámetro de entrada el nombre de uno de los módulos existentes en la BD y visualice el nombre de los alumnos que lo han cursado junto a su nota.
--Al final del listado debe aparecer el nº de suspensos, aprobados, notables y sobresalientes.
--Asimismo, deben aparecer al final los nombres y notas de los alumnos que tengan la nota más alta y la más baja.
--Debes comprobar que las tablas tengan almacenada información y que exista el módulo cuyo nombre pasamos como parámetro al procedimiento.
CREATE OR ALTER PROCEDURE listadoAlumnos (@nombre varchar(20)) AS
BEGIN
	DECLARE @alumno VARCHAR(30),
	@nota int,
	@suspensos int = 0,
	@aprobados int = 0,
	@notables int = 0,
	@sobresalientes int = 0,
	@notaMin int = 0,
	@notaMax int = 0

	DECLARE cAlumnos CURSOR FOR
    SELECT APENOM, NOTA FROM NOTAS AS N
    JOIN ASIGNATURAS AS AG
    ON N.COD = AG.COD
    JOIN ALUMNOS AS AL
    ON AL.DNI = N.DNI
    WHERE NOMBRE = @nombre
    GROUP BY APENOM, NOTA

    OPEN cAlumnos
    FETCH cAlumnos INTO @alumno, @nota

    WHILE(@@FETCH_STATUS = 0)
    BEGIN
        
        IF (@nota >= 5)
        BEGIN
            SET @aprobados += 1
            IF(@nota >= 8)
            BEGIN
                SET @sobresalientes += 1
            END
            ELSE IF (@nota >=7)
            BEGIN
                SET @notables += 1
            END
        END
        ELSE 
        BEGIN
            SET @suspensos += 1
        END

        IF(@nota < @notaMin)
        BEGIN
            SET @notaMin = @nota
        END
        IF(@nota > @notaMax)
        BEGIN
            SET @notaMax = @nota
        END

        PRINT CONCAT (@alumno, ' -> ', @nota)
        
        FETCH cAlumnos INTO @alumno, @nota
    END

        PRINT CONCAT ('Suspensos: ', @suspensos)
        PRINT CONCAT ('Aprobados: ', @aprobados)
        PRINT CONCAT ('Notables: ', @notables)
        PRINT CONCAT ('Sobresaliente: ', @sobresalientes)
        PRINT CONCAT ('Máxima: ', @notaMax)
        PRINT CONCAT ('Mínima: ', @notaMin)

    CLOSE cAlumnos
    DEALLOCATE cAlumnos
END

EXECUTE listadoAlumnos @nombre = 'Entornos Gráficos'

-- EJ3.0

CREATE PROCEDURE UPDStock  AS
BEGIN

	DECLARE @codProducto int,
	@ventas int,
	@stock int


	DECLARE cProduct CURSOR FOR
    SELECT CodProductos, Stock FROM Productos AS P

    OPEN cAlumnos
    FETCH cAlumnos INTO @alumno, @nota

	UPDATE Stock
END

-- EJ3.1


-- EJ3.2




SELECT * FROM Productos
SELECT * FROM Ventas