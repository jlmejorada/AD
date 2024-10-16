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
        PRINT CONCAT ('M�xima: ', @notaMax)
        PRINT CONCAT ('M�nima: ', @notaMin)

    CLOSE cAlumnos
    DEALLOCATE cAlumnos
END

EXECUTE listadoAlumnos @nombre = 'Entornos Gr�ficos'

-- EJ3.A1

CREATE OR ALTER PROCEDURE UPDStock  AS
BEGIN

	DECLARE @codProducto int,
	@codVenta VARCHAR(5)

	DECLARE cProduct CURSOR FOR
    SELECT CodProducto, CodVenta FROM Ventas

    OPEN cProduct
    FETCH cProduct INTO @codProducto, @codVenta

	WHILE(@@FETCH_STATUS = 0)
    BEGIN
		IF ((SELECT Stock FROM Productos WHERE CodProducto=@codProducto) > (SELECT ISNULL(UnidadesVendidas,0)FROM Ventas WHERE CodVenta=@codVenta))
		BEGIN
			UPDATE Productos 
			SET Stock = Stock - (SELECT ISNULL(UnidadesVendidas,0)FROM Ventas WHERE CodVenta=@codVenta)
			WHERE CodProducto = @codProducto
		END
		FETCH cProduct INTO @codProducto, @codVenta
	END
	CLOSE cProduct
	DEALLOCATE cProduct
END

BEGIN TRANSACTION
EXECUTE UPDStock
ROLLBACK


-- EJ3.A2
-- Trigger 1
CREATE OR ALTER TRIGGER ActualizaStockVenta
ON Ventas
AFTER UPDATE
AS
BEGIN
    UPDATE productos
    SET Stock = stock - (I.UnidadesVendidas - D.UnidadesVendidas)
    FROM productos AS P
    JOIN Inserted AS I ON P.CodProducto = I.CodProducto
    JOIN Deleted AS D ON P.CodProducto = D.CodProducto

    DELETE FROM Ventas
    WHERE CodVenta IN (
        SELECT I.CodVenta
        FROM Inserted AS I
        JOIN Deleted AS D ON I.CodVenta = D.CodVenta
        WHERE I.UnidadesVendidas = 0
    )
    
END


-- EJ3.B
CREATE OR ALTER PROCEDURE DatosProdc  AS
BEGIN

	DECLARE @lineaProducto VARCHAR(10),
	@codProducto INT,
	@ventasTotales INT,
	@ventas INT,
	@importeTotal MONEY,
	@precio MONEY

	DECLARE producto CURSOR FOR
    SELECT LineaProducto FROM Productos
	GROUP BY LineaProducto

    OPEN producto
    FETCH producto INTO @lineaProducto

	WHILE(@@FETCH_STATUS = 0)
    BEGIN
		PRINT CONCAT('Linea Producto: ', @lineaProducto)

		DECLARE venta CURSOR FOR
		SELECT CodProducto FROM Productos
		WHERE LineaProducto = @lineaProducto

		OPEN venta
		FETCH venta INTO @codProducto

		WHILE(@@FETCH_STATUS = 0)
		BEGIN
			SET @ventasTotales = (SELECT ISNULL(SUM(UnidadesVendidas),0) FROM Ventas WHERE CodProducto=@codProducto)
			SET @precio = (SELECT PrecioUnitario FROM Productos WHERE CodProducto=@codProducto)
			SET @importeTotal = (@precio*@ventasTotales)
			PRINT CONCAT('     ', @codProducto,'     ' , @ventasTotales ,  '     ', @importeTotal)
			FETCH venta INTO @codProducto
		END

		CLOSE venta
		DEALLOCATE venta

		PRINT ('---------------------------------------------------')
		FETCH producto INTO @lineaProducto
	END
	CLOSE producto
	DEALLOCATE producto
END

EXECUTE DatosProdc
