
#!/bin/bash
# === Mensaje bienvenida
echo Se va a compilar la practica con las dependencias

# === Inputs ===
SRC_DIR=$PWD/src
BIN_DIR=/bin
MAIN=es/uned/lsi/eped/pract2018_2019/Main
JAVA_HOME_JDK=
TMP_FOLDER=$PWD/juego_de_pruebas/tmp

if [ -z "$JAVA_HOME_JDK" ] 
    then
        if [ -z "$JAVA_HOME" ] 
            then 
	        echo Modifica la variable del archivo .sh JAVA_HOME_JDK 
	        read -rsp $'Press any key to continue...\n' -n 1 key
	        exit
	 else
	    JAVA_HOME_JDK="$JAVA_HOME"
	 fi
fi


# === Mostramos variables ===
echo Carpeta codigo = $SRC_DIR
echo Carpeta bin = $BIN_DIR
echo Clase principal = $MAIN
echo JAVA_HOME_JDK = $JAVA_HOME_JDK
echo  
echo 

# === Clean and make temp dir ===
echo Limpiando compilacion anterior
rm -rf "$TMP_FOLDER"
read -rsp $'Press any key to continue...\n' -n 1 key
echo Copiando archivos
if [ ! -e "$TMP_FOLDER" ]
    then
        mkdir "$TMP_FOLDER" 
fi 
mkdir "$TMP_FOLDER$BIN_DIR"
mkdir "$TMP_FOLDER/src"
mkdir "$TMP_FOLDER/src/es"
mkdir "$TMP_FOLDER/src/es/uned"
mkdir "$TMP_FOLDER/src/es/uned/lsi"
mkdir "$TMP_FOLDER/src/es/uned/lsi/eped"
mkdir "$TMP_FOLDER/src/es/uned/lsi/eped/pract2018_2019"
cp -r "$SRC_DIR/es/uned/lsi/eped/pract2018_2019/"* "$TMP_FOLDER/src/es/uned/lsi/eped/pract2018_2019"
echo
echo
read -rsp $'Press any key to continue...\n' -n 1 key
# ===

# === Compile ===
echo Compilando en carpeta temporal
# === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
# echo "$JAVA_HOME_JDK/bin/javac" -d "$TMP_FOLDER$BIN_DIR" -sourcepath "$TMP_FOLDER/src" -cp "juego_de_pruebas/lib/TAD_modified.jar" "$TMP_FOLDER/src/"$MAIN".java"

"$JAVA_HOME_JDK/bin/javac" -d "$TMP_FOLDER$BIN_DIR" -sourcepath "$TMP_FOLDER/src" -cp "juego_de_pruebas/lib/TAD_modified.jar" "$TMP_FOLDER/src/"$MAIN".java"

if [ $? -eq 1 ] 
    then
	echo Compilacion con errores
	read -rsp $'Press any key to continue...\n' -n 1 key
	exit 1
fi

echo Compilacion sin errores
echo
echo
read -rsp $'Press any key to continue...\n' -n 1 key
# ===


# === Run INT ===
echo Ejecutando el programa para enteros con parametro INT
# === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
# echo "$JAVA_HOME_JDK/bin/java" -cp "$TMP_FOLDER$BIN_DIR:juego_de_pruebas/lib/TAD_modified.jar" "$MAIN" INT "juego_de_pruebas/pruebas/Estudiantes_INT.txt"

"$JAVA_HOME_JDK/bin/java" -cp "$TMP_FOLDER$BIN_DIR:juego_de_pruebas/lib/TAD_modified.jar" "$MAIN" INT "juego_de_pruebas/pruebas/Estudiantes_INT.txt" > "juego_de_pruebas/salida/Salida_INT.txt"

if [ $? -eq 1 ] 
    then
	echo Ejecucion con errores
	read -rsp $'Press any key to continue...\n' -n 1 key
	exit 1
fi

echo Ejecucion sin errores
read -rsp $'Press any key to continue...\n' -n 1 key

# === Comprobacion INT ===
echo Comprobando bateria de pruebas para enteros con parametro INT
# === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
# echo "$JAVA_HOME_JDK/bin/java" -jar "juego_de_pruebas/lib/Comparator.jar" "juego_de_pruebas/salida/Salida_INT.txt" "juego_de_pruebas/salida/SalidaEsperada_INT.txt"

"$JAVA_HOME_JDK/bin/java" -jar "juego_de_pruebas/lib/Comparator.jar" "juego_de_pruebas/salida/Salida_INT.txt" "juego_de_pruebas/salida/SalidaEsperada_INT.txt"

if [ $? -eq 1 ] 
    then
	echo Ejecucion con errores
	read -rsp $'Press any key to continue...\n' -n 1 key
	exit 1
fi

echo
echo
read -rsp $'Press any key to continue...\n' -n 1 key

# === Run SEQ ===
echo Ejecutando el programa para secuencias con parametro SEQ
# === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
# echo "$JAVA_HOME_JDK/bin/java" -cp "$TMP_FOLDER$BIN_DIR:juego_de_pruebas/lib/TAD_modified.jar" "$MAIN" SEQ "juego_de_pruebas/pruebas/Estudiantes_SEQ.txt"

"$JAVA_HOME_JDK/bin/java" -cp "$TMP_FOLDER$BIN_DIR:juego_de_pruebas/lib/TAD_modified.jar" "$MAIN" SEQ "juego_de_pruebas/pruebas/Estudiantes_SEQ.txt" > "juego_de_pruebas/salida/Salida_SEQ.txt"

if [ $? -eq 1 ] 
    then
	echo Ejecucion con errores
	read -rsp $'Press any key to continue...\n' -n 1 key
	exit 1
fi

echo Ejecucion sin errores
read -rsp $'Press any key to continue...\n' -n 1 key

# === Comprobacion SEQ ===
echo Comprobando bateria de pruebas para secuencias con parametro SEQ
# === DESCOMENTAR LA SIGUIENTE LINEA SI SE QUIERE IMPRIMIR LA ORDEN === 
# echo "$JAVA_HOME_JDK/bin/java" -jar "juego_de_pruebas/lib/Comparator.jar" "juego_de_pruebas/salida/Salida_SEQ.txt" "juego_de_pruebas/salida/SalidaEsperada_SEQ.txt"

"$JAVA_HOME_JDK/bin/java" -jar "juego_de_pruebas/lib/Comparator.jar" "juego_de_pruebas/salida/Salida_SEQ.txt" "juego_de_pruebas/salida/SalidaEsperada_SEQ.txt"

if [ $? -eq 1 ] 
    then
	echo Ejecucion con errores
	read -rsp $'Press any key to continue...\n' -n 1 key
	exit 1
fi

echo
echo
read -rsp $'Press any key to continue...\n' -n 1 key

exit
# ===
