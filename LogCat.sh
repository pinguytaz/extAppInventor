#/usr/bin

#Leemos LogCat para una etiqueta concreta
TAG=TAGPorDefecto
adb logcat -s $TAG:*
