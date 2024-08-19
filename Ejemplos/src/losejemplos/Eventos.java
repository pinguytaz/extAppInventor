package losejemplos;

// Importacion para darnos accesos a clases internas y anaotaciones AI2
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.runtime.EventDispatcher;

//Externas
import android.util.Log; // Clase del API android para generar LOG

// Descripcion de la extension
@DesignerComponent(version = 1,
                    category = ComponentCategory.EXTENSION,
                    description = "Un ejemplo de propiedades",
                    nonVisible = true,
                    iconName = "")
@SimpleObject(external = true)

// Definimos la clase publica de nuestra extension
public class Eventos extends AndroidNonvisibleComponent {
   int suma;

   public Eventos(ComponentContainer container) {
       super(container.$form());
   }   
   @SimpleFunction(description = "Suma y cuando llega a 5 lanza evento")
   public int Suma() {
      suma++;
      if (suma==5) 
      {
         suma=0;
         Llego("Ha llegado a 5 y se inicia a 0"); // Lanza evento.
      }
      return suma;
   }
   @SimpleEvent(description = "Evento que se dispara si Llega a 5 la suma")
   public void Llego(String texto) {
      EventDispatcher.dispatchEvent(this, "Llego", texto);  //Despacha evento con los datos que le llegan
   }

  //**************** Ejemplo de excepcion
  @SimpleFunction(description = "Funcion que divide")
  public int Divide(int numero1, int numero2) {
     int resultado = 1966; 
     try {
        resultado = numero1 / numero2;
     } catch(Exception e) { OcurreUnError(e.getMessage(),9 ); }
     return resultado;
  }

   @SimpleEvent(description = "Evento que se dispara si ocurre un error")
   public void OcurreUnError(String error, int codError) {
        Log.d("TAGPorDefecto","Ha ocurrido un error");
	EventDispatcher.dispatchEvent(this, "OcurreUnError", error, codError);
    }
}
