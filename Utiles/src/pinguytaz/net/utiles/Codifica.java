/*************************************************************
 *  Autor: Fco. Javier Rodriguez Navarro
 *  WEB: www.pinguytaz.net
 *
 *  Descripción: Funciones de codificación: Hash: MD5, SHA-256 
 *                                          Codifica: Hexadecimal, Base64
 *                                          Encriptacion: AES
 * 
 *  Version 1.0 Agosto 2024
 **********************************************************/
package pinguytaz.net.utiles;

// Importacion para darnos accesos a clases internas y anaotaciones AI2
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.runtime.EventDispatcher;

// Importacion de librerias Android y propias java
import java.security.MessageDigest;                // Para HASH
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.io.UnsupportedEncodingException;

import android.util.Log; // Clase del API android para generar LOG
import android.util.Base64;   // Para codificar a Base64

// Importacion de otras librerias

// Descripcion de la extension
@DesignerComponent(version = 1,
                    category = ComponentCategory.EXTENSION,
                    description = "Utilidades de codificacion: Hash, codifica, encripta",
                    nonVisible = true,
                    iconName = "aiwebres/LogoPingu.png")
@SimpleObject(external = true)

// Definimos la clase publica de nuestra extension
public class Codifica extends AndroidNonvisibleComponent {
   private String TAG="LOG-UTILIES";

   public Codifica(ComponentContainer container) {
       super(container.$form());
   }   

   // Funciones Hash.
   // MD5
   @SimpleFunction(description = "Funcion que convierte un String a un MD5")
   public String Hash_MD5(String texto) {
       String resultado = "0102030405060708090A0B0C0D0E0F";
 
       try {
          MessageDigest md5 = MessageDigest.getInstance("MD5");
          md5.update(texto.getBytes());
          byte[] digest = md5.digest();
          // Convertimos el array de bytes a String en formato Hexadeciaml
          StringBuffer hexString = new StringBuffer();
          for (int i = 0;i<digest.length;i++) {
             hexString.append(String.format("%02x", (0xFF & digest[i])));
          }
          resultado = hexString.toString();  
       } catch(Exception e) { OcurreUnError(e.getMessage(),"En MD5" ); }
 
       return resultado;
   }

   // SHA256
   @SimpleFunction(description = "Funcion que convierte un String a un Hash SHA256 (SHA2 de 256 y 64 rondas")
   public String Hash_SH256(String texto) {
       String resultado = "0102030405060708090A0B0C0D0E0F1112131415161718191A1B1C1D1E1F";
       try {
          MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
          sha256.update(texto.getBytes());
          byte[] digest = sha256.digest();
          // Convertimos el array de bytes a String en formato Hexadeciaml
          StringBuffer hexString = new StringBuffer();
          for (int i = 0;i<digest.length;i++) {
             //hexString.append(Integer.toHexString(0xFF & digest[i]));
             hexString.append(String.format("%02x", (0xFF & digest[i])));
          }
          resultado = hexString.toString();  
       } catch(Exception e) { OcurreUnError(e.getMessage(),"En SHA256" ); }
 
      return resultado;
   }
 
   // Base16  a Hexadecimal
   @SimpleFunction(description = "Funcion que convierte un String en Hexadecimal")
   public String CodiA_Hex(String texto) {
       String resultado = "En Hexadecimal la cadena de texto";
       try {
          StringBuffer hexString = new StringBuffer();
          for (int i = 0;i<texto.length();i++) {
                hexString.append(String.format("%02x", (0xFF & texto.charAt(i))));
          }
          resultado = hexString.toString();
       } catch(Exception e) { OcurreUnError(e.getMessage(),"En CodiAHEX" ); }
       return resultado;
   } 
 
   @SimpleFunction(description = "Funcion que convierte un String HEX a cadena de caracteres")
   public String CodiDe_Hex(String hex) {
       String resultado ="Datos en HEX";
       try {
          char[] ascii = new char[hex.length() / 2]; 
          for (int i = 0; i < hex.length(); i += 2) {  // Avanzamos de 2 en dos.
             String hexByte = hex.substring(i, i + 2);  // Obtiene dos caracteres
             int asciiValue = Integer.parseInt(hexByte, 16); // Convertir hexadecimal a decimal
             ascii[i / 2] = (char) asciiValue; // Convertir decimal a caracter ASCII
         }
         resultado = new String(ascii);
      } catch(Exception e) { OcurreUnError(e.getMessage(),"En CodiDeHEX" ); }
      return resultado;
   } 
 
   // Base64
   @SimpleFunction(description = "Funcion que convierte un String en Base 64")
   public String CodiA_Base64(String texto) {
      String resultado = "La Cadena";
      try {
         byte[] bytesTexto = texto.getBytes("UTF-8");
         byte[] cadenaBase64 = Base64.encode(bytesTexto, Base64.DEFAULT);
         resultado = new String(cadenaBase64);
      } catch(Exception e) { OcurreUnError(e.getMessage(),"En CodiABase64" ); }
      return resultado;
   } 
   @SimpleFunction(description = "Funcion que convierte de base 64 a String")
   public String CodiDe_Base64(String base64) {
      String resultado = "La cadena despues de 64";
      try {
         byte[] cadena = Base64.decode(base64, Base64.DEFAULT);
         resultado = new String(cadena);
      } catch(Exception e) { OcurreUnError(e.getMessage(),"En CodiDeBase64" ); }
      return resultado;
   } 


   // Encriptación
   @SimpleFunction(description = "Realiza la encriptación en AES")
   public String Encripta_AES(String textoACifrar, String clave, String salt) {
      try {
         // Generamos IV
         SecureRandom secureRandom = new SecureRandom();
         byte[] iv = new byte[16];
         secureRandom.nextBytes(iv);
         IvParameterSpec ivspec = new IvParameterSpec(iv);
   
         // Se genera clave AES con la clave,salt
         SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
         KeySpec spec = new PBEKeySpec(clave.toCharArray(), salt.getBytes(), 65536, 256);
         SecretKey tmp = factory.generateSecret(spec);
         SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(), "AES");
   
         // Ciframos
         Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
         cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivspec);
   
         byte[] cipherText = cipher.doFinal(textoACifrar.getBytes("UTF-8"));
         byte[] datosEncriptados = new byte[iv.length + cipherText.length];
         System.arraycopy(iv, 0, datosEncriptados, 0, iv.length);
         System.arraycopy(cipherText, 0, datosEncriptados, iv.length, cipherText.length);
   
         // Convertimos a HEX
         StringBuffer hexString = new StringBuffer();
         for (int i = 0;i<datosEncriptados.length;i++) {
            hexString.append(String.format("%02x", (0xFF & datosEncriptados[i])));
         }
         return hexString.toString();
      } catch(Exception e) { OcurreUnError(e.getMessage(),"En Encripta_AES" ); }
      return "";
   } 

   @SimpleFunction(description = "Realiza la desencriptación en AES")
   public String Desencripta_AES(String textoADescifrar, String clave, String salt) {
      try {
         // Lo primero es convertir HEX al array de bytes
         byte[] datosCifrados = new byte[textoADescifrar.length() / 2]; 
         for (int i = 0; i < textoADescifrar.length(); i += 2) {  // Avanzamos de 2 en dos.
            String hexByte = textoADescifrar.substring(i, i + 2);  // Obtiene dos caracteres
            int asciiValue = Integer.parseInt(hexByte, 16); // Convertir hexadecimal a decimal
            datosCifrados[i / 2] = (byte) asciiValue; // Convertir decimal a caracter ASCII
         }

         byte[] iv = new byte[16];
         System.arraycopy(datosCifrados, 0, iv, 0, iv.length);
         IvParameterSpec ivspec = new IvParameterSpec(iv);

         SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
         KeySpec spec = new PBEKeySpec(clave.toCharArray(), salt.getBytes(), 65536, 256);
         SecretKey tmp = factory.generateSecret(spec);
         SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(), "AES");
 
         Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
         cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivspec);

         byte[] cipherText = new byte[datosCifrados.length - 16];
         System.arraycopy(datosCifrados, 16, cipherText, 0, cipherText.length);

         byte[] textoDescifrado = cipher.doFinal(cipherText);
         return new String(textoDescifrado, "UTF-8");
      } catch(Exception e) { OcurreUnError(e.getMessage(),"En Desencripta_AES" ); }
      return "";
   } 

   // Evento información de error
   @SimpleEvent(description = "Dispara evento de Error")
   public void OcurreUnError(String error, String funcion) {
      String texto = "Ocurre un error en " + funcion + " tipo: " + error;
      Log.e(TAG,texto);
      EventDispatcher.dispatchEvent(this, "OcurreUnError", error, funcion);
   }
}
