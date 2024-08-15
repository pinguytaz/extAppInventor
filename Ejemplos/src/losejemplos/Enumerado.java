package losejemplos;

// Importacion para darnos accesos a clases internas y anaotaciones AI2
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.Options;

// Importamos las auxiliares
import losejemplos.helpers.TipoEnum;

// Descripcion de la extension
@DesignerComponent(version = 1,
                    category = ComponentCategory.EXTENSION,
                    description = "Un ejemplo de función que recoge un enumerado",
                    nonVisible = true,
                    iconName = "")
@SimpleObject(external = true)

// Definimos la clase publica de nuestra extension
public class Enumerado extends AndroidNonvisibleComponent {

    public Enumerado(ComponentContainer container) {
        super(container.$form());
    }   

  // Funciones de ejecución Log para dar un Log
  @SimpleFunction(description = "Funcion recogiendo un enumerado y retornando un texto segun el valor.")
  public String LaFuncion(@Options(TipoEnum.class) final int tipo) {
     String retorno="";
     switch(tipo) {
        case 0:
           retorno="el valor 0 que pone UnValor";
           break;
        case 1:
           retorno="Este es el uno";
           break;
        case 2:
           retorno="Pues este es un DOS";
           break;
        case 3:
           retorno="Este corresponderia al de varios";
           break;
        default:
           retorno="Este valor no deberia existir";
     }
     return retorno;
   }
}
