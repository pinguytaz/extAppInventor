# Extensiones AppInventor

Extensiones para utilizar en AppInventor.  

<BR>

__**[Utiles](Utiles)**__  
Conjunto de extensiones para la ayuda en la depuración, cifrados y obtencion de información del sistema.  
  
**Logs**  
Nos permite escribir mensajes en LogCat  
En la funcion Log() definiremos el texto a enviar y el tipo de log: Verbose, Debug, Info, Advertencia y Error  

<p align="center"><img src=Imagenes/LlamadaLog.png /></p>
  
**Codifica**  
Funciones para codificar Strings, ya sean Hash como MD5 y SHA-256, conversiones(más adelante) a Base64 y Base 16 y encriptación(más adelante).  
Tenemos un componente evento que captura las posibles excepciónes de las funciones:
<center><img src=Imagenes/Evento_OcurreUnError.png /></p>
  
- **HASH: MD5(16 bytes) y SHA-256(32 bytes)** se les pasamos el texto y retorna la cadena con el HASH  
  
<p align="center"> <img src=Imagenes/FuncionesHASH.png /></p>
  
- **Codifica Hexadecimal y Base 64** Se pasa la cadena de texto o HEXadecimal/Base64  
  
<p align="center"> <img src=Imagenes/CodificacionHEX.png /></p>  
<p align="center"> <img src=Imagenes/CodificacionBase64.png /></p>  
  

<BR>

_**[Ejemplos](Ejemplos)**_  
Ejemplos de extensiones realizadas para los POST de https://www.pinguytaz.net  
  
<br><br>

__Website__: <https://www.pinguytaz.net>

