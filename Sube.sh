#/usr/bin

#Subimos ejecutable .apk para probar
# Primero miramos emuladores en ejecución o dispositivos conectados  "adb devices"
DISPOSITIVO=emulator-5554
FICHERO=bin/PruebasExtensiones.apk
adb -s $DISPOSITIVO install $FICHERO
