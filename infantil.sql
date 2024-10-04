--Ejercicio 1 Haz una función llamada DevolverCodDept que reciba el nombre de un departamento y devuelva su código.
	CREATE OR ALTER FUNCTION DevolverCodDept(@nombre varchar(20))
	RETURNS smallint
		BEGIN
			DECLARE @res smallint
			SET @res = (SELECT DEPTNO FROM DEPT WHERE DNAME = @nombre)
			RETURN @res
		END

	SELECT dbo.DevolverCodDept ('RESEARCH') as Nombre


--Ejercicio 2 Realiza un procedimiento llamado HallarNumEmp que recibiendo un nombre de departamento, muestre en pantalla el número de empleados de dicho departamento. Puedes utilizar la función creada en el ejercicio 1.
--            Si el departamento no tiene empleados deberá mostrar un mensaje informando de ello. Si el departamento no existe se tratará la excepción correspondiente.
CREATE OR ALTER PROCEDURE HallarNumEmp(@nombre varchar(10))
AS
	BEGIN
			SELECT COUNT(*) AS NumEmpleados FROM EMP WHERE DEPTNO = (SELECT dbo.DevolverCodDept (@nombre) as Código)
	END


EXECUTE HallarNumEmp @nombre = 'SALES'


--Ejercicio 3 Realiza una función llamada CalcularCosteSalarial que reciba un nombre de departamento y devuelva la suma de los salarios y comisiones de los empleados de dicho departamento. Trata las excepciones que consideres necesarias.
CREATE OR ALTER FUNCTION CalcularCosteSalarial(@nombreDept varchar(20))
RETURNS INT
	BEGIN
		DECLARE @sumaSalario money
		DECLARE @sumaComisiones money
		DECLARE @res money
		SET @sumaSalario = (SELECT SUM(SAL) FROM EMP WHERE DEPTNO = dbo.DevolverCodDept (@nombreDept))
		SET @sumaComisiones = (SELECT SUM(ISNULL(COMM,0)) FROM EMP WHERE DEPTNO = dbo.DevolverCodDept (@nombreDept))
		SET @res = COALESCE(@sumaSalario + @sumaComisiones, 0)
		RETURN @res
	END

SELECT dbo.CalcularCosteSalarial ('SALES') AS CosteSalarial


--Ejercicio 4 cr Realiza un procedimiento MostrarCostesSalariales que muestre los nombres de todos los departamentos y el coste salarial de cada uno de ellos. Puedes usar la función del ejercicio 3.
CREATE OR ALTER PROCEDURE MostrarCostesSalariales AS
BEGIN
DECLARE @noDepto VARCHAR(15)
DECLARE @dinerito int


DECLARE mycursor CURSOR FOR
SELECT DNAME FROM DEPT

OPEN mycursor
FETCH mycursor into @noDepto
	WHILE(@@FETCH_STATUS = 0)
	BEGIN
		SET @dinerito = (SELECT dbo.CalcularCosteSalarial (@noDepto))
		print concat ('Departamento: ', @noDepto,'	Coste: ', @dinerito)
		FETCH mycursor into @noDepto
	END


CLOSE mycursor
DEALLOCATE mycursor
END


EXEC MostrarCostesSalariales

SELECT * FROM DEPT

--Ejercicio 5 Realiza un procedimiento MostrarAbreviaturas que muestre las tres primeras letras del nombre de cada empleado.
CREATE OR ALTER PROCEDURE MostrarAbreviaturas
AS
	BEGIN
			SELECT SUBSTRING (ENAME, 1, 3 ) as Abrv FROM EMP
	END

EXECUTE MostrarAbreviaturas


--Ejercicio 6 cr Realiza un procedimiento MostrarMasAntiguos que muestre el nombre del empleado más antiguo de cada departamento junto con el nombre del departamento. Trata las excepciones que consideres necesarias.
CREATE OR ALTER PROCEDURE MostrarMasAntiguos
AS
	BEGIN
		DECLARE @naEMP VARCHAR(15)
		DECLARE @naDEPT VARCHAR(15)
		DECLARE @noDEPT VARCHAR(15)
		DECLARE mycursor CURSOR FOR
		SELECT DNAME, DEPTNO FROM DEPT
		OPEN mycursor
		FETCH mycursor into @naDEPT, @noDEPT
		WHILE(@@FETCH_STATUS = 0)
		BEGIN
			SET @naEMP = (SELECT TOP 1 ENAME FROM EMP WHERE DEPTNO=@noDEPT ORDER BY HIREDATE desc)
			print concat (@naDEPT,':', @naEMP)
			FETCH mycursor into @naDEPT, @noDEPT
		END
		CLOSE mycursor
		DEALLOCATE mycursor
	END

EXECUTE MostrarMasAntiguos

SELECT * FROM EMP
SELECT * FROM DEPT
SELECT * FROM SALGRADE
SELECT * FROM BONUS


--Ejercicio 7 cr Realiza un procedimiento MostrarJefes que reciba el nombre de un departamento y muestre los nombres de los empleados de ese departamento que son jefes de otros empleados.Trata las excepciones que consideres necesarias.
CREATE OR ALTER PROCEDURE MostrarJefes
AS
	BEGIN
		DECLARE @naEMP VARCHAR(15)
		DECLARE @noDEPT VARCHAR(15)
		DECLARE mycursor CURSOR FOR
		SELECT DNAME, DEPTNO FROM DEPT
		OPEN mycursor
		FETCH mycursor into @naDEPT, @noDEPT
		WHILE(@@FETCH_STATUS = 0)
		BEGIN
			SET @naEMP = (SELECT ENAME FROM EMP WHERE DEPTNO=@noDEPT ORDER BY HIREDATE desc)
			print @naDEPT
			FETCH mycursor into @naDEPT, @noDEPT
		END
		CLOSE mycursor
		DEALLOCATE mycursor
	END

EXECUTE MostrarJefes

SELECT * FROM EMP
SELECT * FROM DEPT
SELECT * FROM SALGRADE
SELECT * FROM BONUS


--Ejercicio 8 Realiza un procedimiento MostrarMejoresVendedores que muestre los nombres de los dos vendedores con más comisiones. Trata las excepciones que consideres necesarias.
CREATE OR ALTER PROCEDURE MostrarMejoresVendedores
AS
	BEGIN
			SELECT TOP 2 ENAME FROM EMP
			ORDER BY COMM DESC
	END

EXECUTE MostrarMejoresVendedores


--Ejercicio 10 Realiza un procedimiento RecortarSueldos que recorte el   sueldo un 20% a los empleados cuyo nombre empiece por la  letra que recibe como parámetro.Trata las excepciones  que consideres necesarias
CREATE OR ALTER PROCEDURE RecortarSueldos (@letra char)
AS
	BEGIN
			UPDATE EMP
			SET SAL=SAL*0.8
			WHERE ENAME LIKE CONCAT(@letra,'%')
	END

BEGIN TRANSACTION
EXECUTE RecortarSueldos @letra='A'
SELECT * FROM EMP
ROLLBACK


--Ejercicio 11 cr Realiza un procedimiento BorrarBecarios que borre a los dos empleados más nuevos de cada departamento. Trata las excepciones que consideres necesarias.
CREATE OR ALTER PROCEDURE BorrarBecarios
AS
	BEGIN
		DECLARE @naEMP VARCHAR(15)
		DECLARE @noDEPT VARCHAR(15)
		DECLARE mycursor CURSOR FOR
		SELECT DNAME, DEPTNO FROM DEPT
		OPEN mycursor
		FETCH mycursor into @naEMP, @noDEPT
		WHILE(@@FETCH_STATUS = 0)
		BEGIN
			DELETE FROM EMP WHERE EMPNO IN (SELECT TOP 2 EMPNO FROM EMP WHERE DEPTNO=@noDEPT ORDER BY HIREDATE asc)
			FETCH mycursor into @naEMP, @noDEPT
		END
		CLOSE mycursor
		DEALLOCATE mycursor
	END

BEGIN TRANSACTION
EXECUTE BorrarBecarios
SELECT * FROM EMP
ROLLBACK