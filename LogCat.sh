#/usr/bin

#Leemos LogCat para una etiqueta concreta
#TAG=TAGPorDefecto
TAG=TAGListas
adb logcat -s $TAG:*
