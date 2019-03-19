@echo off

REM === Mensaje bienvenida
echo Se va a compilar la practica con las dependencias

REM === Inputs ===
set SRC_DIR=%cd%\src
set BIN_DIR=\bin
set MAIN=es/uned/lsi/eped/pract2018_2019/Main
set JAVA_HOME_JDK=""
set TMP_FOLDER=%cd%\juego_de_pruebas\tmp

IF %JAVA_HOME_JDK%=="" (

	IF "%JAVA_HOME%" == "" (
	    echo Modifica la variable del archivo bat JAVA_HOME_JDK 
	    pause
	    exit
	) ELSE (
	    set JAVA_HOME_JDK="%JAVA_HOME%"
	)
)


REM === Mostramos variables ===
echo Carpeta codigo = %SRC_DIR%
echo Carpeta bin = %BIN_DIR%
echo Clase principal = %MAIN%
echo JAVA_HOME_JDK = %JAVA_HOME_JDK%
echo. 
echo.

REM === Clean and make temp dir ===
echo Limpiando compilacion anterior 
rd /q /s "%TMP_FOLDER%"
pause
if not exist "%TMP_FOLDER%" mkdir "%TMP_FOLDER%" 
mkdir "%TMP_FOLDER%%BIN_DIR%"
mkdir "%TMP_FOLDER%\src"
mkdir "%TMP_FOLDER%\src\es"
mkdir "%TMP_FOLDER%\src\es\uned"
mkdir "%TMP_FOLDER%\src\es\uned\lsi"
mkdir "%TMP_FOLDER%\src\es\uned\lsi\eped"
mkdir "%TMP_FOLDER%\src\es\uned\lsi\eped\pract2018_2019"
xcopy /s/q "%SRC_DIR%\es\uned\lsi\eped\pract2018_2019" "%TMP_FOLDER%\src\es\uned\lsi\eped\pract2018_2019"
echo.
echo.
pause
REM ===

REM === Compile ===
echo Compilando en carpeta temporal
REM === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
REM echo %JAVA_HOME_JDK%"\bin\javac" -d "%TMP_FOLDER%%BIN_DIR%" -sourcepath "%TMP_FOLDER%\src" -cp "juego_de_pruebas/lib/TAD_modified.jar" "%TMP_FOLDER%\src\%MAIN%.java"

%JAVA_HOME_JDK%"\bin\javac" -d "%TMP_FOLDER%%BIN_DIR%" -sourcepath "%TMP_FOLDER%\src" -cp "juego_de_pruebas/lib/TAD_modified.jar" "%TMP_FOLDER%\src\%MAIN%.java"
if errorlevel 1 (
	echo Compilacion con errores
	pause
	exit /B 1
)

echo Compilacion sin errores
echo.
echo.
pause
REM ===

REM === Run INT ===
echo Ejecutando el programa para enteros con parametro INT
REM === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
REM echo %JAVA_HOME_JDK%"\bin\java" -cp "%TMP_FOLDER%%BIN_DIR%;juego_de_pruebas/lib/TAD_modified.jar" "%MAIN%" INT "juego_de_pruebas/pruebas/Estudiantes_INT.txt"

%JAVA_HOME_JDK%"\bin\java" -cp "%TMP_FOLDER%%BIN_DIR%;juego_de_pruebas/lib/TAD_modified.jar" "%MAIN%" INT "juego_de_pruebas/pruebas/Estudiantes_INT.txt" > "juego_de_pruebas/salida/Salida_INT.txt"

if errorlevel 1 (
	echo Ejecucion con errores
	pause
	exit /B 1
)

echo Ejecucion sin errores
echo. 
echo.
pause

REM === Comprobacion INT ===
echo Comprobando bateria de pruebas para enteros con parametro INT
REM === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
REM echo %JAVA_HOME_JDK%"\bin\java" -jar "juego_de_pruebas/lib/Comparator.jar" "juego_de_pruebas/salida/Salida_INT.txt" "juego_de_pruebas/salida/SalidaEsperada_INT.txt"

%JAVA_HOME_JDK%"\bin\java" -jar "juego_de_pruebas/lib/Comparator.jar" "juego_de_pruebas/salida/Salida_INT.txt" "juego_de_pruebas/salida/SalidaEsperada_INT.txt"

if errorlevel 1 (
	echo Ejecucion con errores
	pause
	exit /B 1
)
echo. 
echo.
pause

REM === Run SEQ ===
echo Ejecutando el programa para secuencias con parametro SEQ
REM === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
REM echo %JAVA_HOME_JDK%"\bin\java" -cp "%TMP_FOLDER%%BIN_DIR%;juego_de_pruebas/lib/TAD_modified.jar" "%MAIN%" SEQ "juego_de_pruebas/pruebas/Estudiantes_SEQ.txt"

%JAVA_HOME_JDK%"\bin\java" -cp "%TMP_FOLDER%%BIN_DIR%;juego_de_pruebas/lib/TAD_modified.jar" "%MAIN%" SEQ "juego_de_pruebas/pruebas/Estudiantes_SEQ.txt" > "juego_de_pruebas/salida/Salida_SEQ.txt"

if errorlevel 1 (
	echo Ejecucion con errores
	pause
	exit /B 1
)

echo Ejecucion sin errores
echo. 
echo.
pause

REM === Comprobacion SEQ===
echo Comprobando bateria de pruebas para secuencias con parametro SEQ
REM === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
REM echo %JAVA_HOME_JDK%"\bin\java" -jar "juego_de_pruebas/lib/Comparator.jar" "juego_de_pruebas/salida/Salida_SEQ.txt" "juego_de_pruebas/salida/SalidaEsperada_SEQ.txt"

%JAVA_HOME_JDK%"\bin\java" -jar "juego_de_pruebas/lib/Comparator.jar" "juego_de_pruebas/salida/Salida_SEQ.txt" "juego_de_pruebas/salida/SalidaEsperada_SEQ.txt"

if errorlevel 1 (
	echo Ejecucion con errores
	pause
	exit /B 1
)
echo. 
echo.
pause
exit
REM ===