package losejemplos;

// Importacion para darnos accesos a clases internas y anaotaciones AI2
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.annotations.SimpleFunction;

// Descripcion de la extension
@DesignerComponent(version = 1,
                    category = ComponentCategory.EXTENSION,
                    description = "Un ejemplo simple",
                    nonVisible = true,
                    iconName = "")
@SimpleObject(external = true)

// Definimos la clase publica de nuestra extension
public class Ej1 extends AndroidNonvisibleComponent {

    public Ej1(ComponentContainer container) {
        super(container.$form());
    }   

  // Funciones de ejecución Log para dar un Log
  @SimpleFunction(description = "Primera funcion de ejemplo recibe un String y lo transforma en otro que contiente este")
  public String Cadena(String texto) {
     String resultado = "Ejemplo -- " + texto + " --";
     return resultado;
  }
}
