package losejemplos;

// Importacion para darnos accesos a clases internas y anaotaciones AI2
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.YailList;

// Importacion de clases de android
import android.util.Log; // Clase del API android para generar LOG

// Otras importaciones
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

// Descripcion de la extension
@DesignerComponent(version = 1,
                    category = ComponentCategory.EXTENSION,
                    description = "Un ejemplo de uso de listas como parametros y retornos",
                    nonVisible = true,
                    iconName = "")
@SimpleObject(external = true)

// Definimos la clase publica de nuestra extension
public class Listas extends AndroidNonvisibleComponent {

   private String TAG="TAGListas";

   public Listas(ComponentContainer container) {
       super(container.$form());
   }   

   @SimpleFunction(description = "Funcion que recoge como parametros una lista de numeros y la suma dando resultados.")
   public int Suma(YailList enteros ) {
      int suma = 0;

      // Recorremos la lista y sumamos los elementos
      for (final Object o : enteros.toArray()) {     // toArray genera un array de objetos de los elementos de la lista
         try {
           suma += Integer.parseInt(o.toString());
         } catch (NumberFormatException e) {
           throw new YailRuntimeError(e.toString(), "Excepción de error de formato.");
         }
      }
      return suma;
   }

   @SimpleFunction(description = "Funcion que descompone en palabras")
   public YailList Descompone(String cadena) {
      StringTokenizer tokens=new StringTokenizer(cadena, " ");   // Tokenizamos la cadena siendo el separador el espacio.
      // Recorremos los tokens para irlos añadiendo a la lista
      List milista = new ArrayList<>();
      while (tokens.hasMoreTokens ()) {
         String tempo = tokens.nextToken();
         //Log.i(TAG,tempo);
         milista.add(tempo);
      }
      
      //Log.i(TAG,"Nuevo con CAMBIO y List");
      //int elementos= milista.size();   // Elementos de la Lista.
      //Log.i(TAG,String.valueOf(elementos));

      YailList resultado = YailList.makeList(milista);
      resultado.makeList(milista);
      //elementos= resultado.size();   // Elementos de la Lista.
      //Log.i(TAG,String.valueOf(elementos));
      return resultado;
   }

}   // Fin de la clase
