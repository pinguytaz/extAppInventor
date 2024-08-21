/*************************************************************
 *  Autor: Fco. Javier Rodriguez Navarro
 *  WEB: www.pinguytaz.net
 *
 *  Descripción: Funciones de codificación: Hash: MD5, SHA-256 
 *                                          Codifica: Hexadecimal,
 *                                          Proximo Base64
 *                                          Proximo Encriptacion: XOR, ¿?
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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
       StringBuffer hexString = new StringBuffer();
       for (int i = 0;i<texto.length();i++) {
             hexString.append(String.format("%02x", (0xFF & texto.charAt(i))));
       }
       resultado = hexString.toString();
       return resultado;
   } 
 
   @SimpleFunction(description = "Funcion que convierte un String HEX a cadena de caracteres")
   public String CodiDe_Hex(String hex) {
   char[] ascii = new char[hex.length() / 2]; 
       for (int i = 0; i < hex.length(); i += 2) {  // Avanzamos de 2 en dos.
          String hexByte = hex.substring(i, i + 2);  // Obtiene dos caracteres
          int asciiValue = Integer.parseInt(hexByte, 16); // Convertir hexadecimal a decimal
          ascii[i / 2] = (char) asciiValue; // Convertir decimal a caracter ASCII
      }
      String resultado = new String(ascii);
      return resultado;
   } 
 
   // Base64
   /*@SimpleFunction(description = "Funcion que convierte un String en Base 64")
   public String Codi_Base64(String texto) {
       String resultado = "El Codigo en Base 64";
       return resultado;
   } 
*/
 
   // Evento información de error
   @SimpleEvent(description = "Dispara evento de Error")
   public void OcurreUnError(String error, String funcion) {
      String texto = "Ocurre un error en " + funcion + " tipo: " + error;
      Log.e(TAG,texto);
      EventDispatcher.dispatchEvent(this, "OcurreUnError", error, funcion);
   }
}
