/*************************************************************
 *  Autor: Fco. Javier Rodriguez Navarro
 *  WEB: www.pinguytaz.net
 *
 *  Descripción: Extensión para generar mensajes de Log desde AppInventor.
 * 
 *  Version 1.0 Agosto 2024
 **********************************************************/
package pinguytaz.net.utiles;

// Importacion para darnos accesos a clases internas y anaotaciones AI2
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.Options;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.ListView;
import com.google.appinventor.components.common.ComponentCategory;

// importacion propias
import pinguytaz.net.utiles.helpers.TiposLog;

// Importacion de clases de android
import android.util.Log; // Clase del API android para generar LOG

// Descripcion de la extension
@DesignerComponent(version = 1,
                    category = ComponentCategory.EXTENSION,
                    description = "Extension para genera logs en LogCat",
                    nonVisible = true,
                    iconName = "aiwebres/LogoPingu.png")
@SimpleObject(external = true)

// Definimos la clase publica de nuestra extension
public class Logs extends AndroidNonvisibleComponent {
    private String TAG="TAGPorDefecto" ;      // propiedad que tendra el nombre de TAG con el que lanzar mensajes.

    public Logs(ComponentContainer container) {
        super(container.$form());
    }   

   // Funciones para poder poner la propiedad TAG
   @SimpleProperty (category = PropertyCategory.BEHAVIOR, description="Retorna el nombre del TAG con el que se generan los LOG")
   public String Get_TAG() {
      return TAG;
   }
   @SimpleProperty (description="Pone el nombre del TAG con el que se generan los LOG")
   public void Set_TAG(String tag) {
       TAG=tag;
   }

   // Propiedad en el diseñador.
   @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING, defaultValue = "TAGPorDefecto")
   @SimpleProperty (category = PropertyCategory.BEHAVIOR, description="Pone el nombre del TAG con el que se generan los LOG", userVisible = false)
   public void ElTag(String tag) {
       TAG=tag;
   }

  // Funciones de ejecución Log para dar un Log
  @SimpleFunction(description = "Envia traza a LOG para debuggear dando como parametros el texto y el tipo: verbose, debug, info, advertencia y error </B>")
  public void Log(String texto, @Options(TiposLog.class) final int tipo ) {
     switch(tipo) {
        case 0:
           Log.v(TAG, texto);
           break;
        case 1:
           Log.d(TAG, texto);
           break;
        case 2:
           Log.i(TAG, texto);
           break;
        case 3:
           Log.w(TAG, texto);
           break;
        case 4:
           Log.e(TAG, texto);
           break;
        default:
           Log.e(TAG, texto);
     }
  }
}
    
