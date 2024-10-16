USE master
CREATE DATABASE BecasJoseLuisMejoradaMarin
USE BecasJoseLuisMejoradaMarin

CREATE TABLE AlumnosSolicitantes(
dni varchar (20) PRIMARY KEY,
nombre varchar (20),
nota float,
cuantia money
)

CREATE TABLE AlumnosConBeca(
dni varchar (20) PRIMARY KEY,
nombre varchar (20),
cuantia money,
CONSTRAINT FK_AlumnosConBeca_AlumnosSolicitantes
FOREIGN KEY (dni)
REFERENCES AlumnosSolicitantes (dni)
)

insert into AlumnosSolicitantes values ('11111111A', 'Ana Albaricoque', 9.8, 150)
insert into AlumnosSolicitantes values ('22222222B', 'Beatriz Blanco', 9.5, 200)
insert into AlumnosSolicitantes values ('33333333C', 'Cristina Cortina', 7.6, 100)
insert into AlumnosSolicitantes values ('44444444D', 'Daniel Dado', 7.6, 100)
insert into AlumnosSolicitantes values ('55555555E', 'Enriqueta Espera', 6.9, 150)
insert into AlumnosSolicitantes values ('66666666F', 'Federico Frio', 6.8, 50)
insert into AlumnosSolicitantes values ('77777777G', 'Guillermo Gil', 6.1, 100)

CREATE OR ALTER PROCEDURE becarAlumnoJoseLuis (@dinero money)
AS
BEGIN
	DECLARE @dniAlumno varchar(9),
	@nombreAlumno varchar(20),
	@notaAlumno decimal,
	@cuantiaAlumno money

	DECLARE recorrerALumno CURSOR FOR
	SELECT dni, nota, nombre, cuantia FROM AlumnosSolicitantes
	ORDER BY nota desc, nombre 

	OPEN recorrerAlumno
	FETCH recorrerAlumno INTO @dniAlumno, @notaAlumno, @nombreAlumno, @cuantiaAlumno

	WHILE (@@FETCH_STATUS = 0)
	BEGIN
			IF (@dinero >= @cuantiaAlumno)
			BEGIN

				SET @dinero = @dinero-@cuantiaAlumno
				insert into AlumnosConBeca values (@dniAlumno, @nombreAlumno, @cuantiaAlumno)
				PRINT(CONCAT('El alumno ', @nombreAlumno, ' ha sido agraciado con la beca: ', @cuantiaAlumno))
				PRINT('------------------------------------------------------------------------------------')
			END
			ELSE 
				BEGIN
					PRINT(CONCAT('Ohhh!!!, No tenemos dinero suficiente para asignar la beca al alumno ', @nombreAlumno, '. Ha solicitado ',
						@cuantiaAlumno, ' y disponemos de ', @dinero, '.'))
					PRINT('------------------------------------------------------------------------------------')
				END
		FETCH recorrerAlumno INTO @dniAlumno, @notaAlumno, @nombreAlumno, @cuantiaAlumno
	END
	PRINT('============================================================================================')
	PRINT(CONCAT('Ha sobrado ', @dinero, ' euros de las becas'))
	CLOSE recorrerAlumno
	DEALLOCATE recorrerAlumno
END

BEGIN TRANSACTION Prueba
EXECUTE becarAlumnoJoseLuis @dinero=800
ROLLBACK


SELECT * FROM AlumnosSolicitantes
SELECT * FROM AlumnosConBeca