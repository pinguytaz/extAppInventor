package losejemplos;

// Importacion para darnos accesos a clases internas y anaotaciones AI2
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleProperty;

// Descripcion de la extension
@DesignerComponent(version = 1,
                    category = ComponentCategory.EXTENSION,
                    description = "Un ejemplo de propiedades",
                    nonVisible = true,
                    iconName = "")
@SimpleObject(external = true)

// Definimos la clase publica de nuestra extension
public class Propiedades extends AndroidNonvisibleComponent {

    private int multiplicador = 0; // Propiedad que por defecto es 0.
    private boolean por10 = false;  // Indicara si al resultado lo multiplica o no por 10.

    public Propiedades(ComponentContainer container) {
        super(container.$form());
    }   

  // Funciones de ejecución Log para dar un Log
  @SimpleFunction(description = "Funcion que multiplica el valor")
  public int Multiplica(int numero) {
     if(por10) return (numero * multiplicador) * 10;
     else return numero * multiplicador;
  }

  // Propiedades
  @SimpleProperty (description="Retorna el valor del multiplicador")
  //@SimpleProperty (category = PropertyCategory.BEHAVIOR, description="Retorna el valor del multiplicador")
   public int Get_multiplicador() {
      return multiplicador;
   }
   //@SimpleProperty (category = PropertyCategory.BEHAVIOR, description="Pone el valor al multiplicador")
   @SimpleProperty (description="Pone el valor al multiplicador")
   public void Set_multiplicador(int multiplicador) {
       this.multiplicador=multiplicador;
   }
   // Propiedad de diseño
   @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN)
   @SimpleProperty (category = PropertyCategory.BEHAVIOR, userVisible=false, description="Pone si se multiplica o no por 10.")
   public void MultiplicaPorDiez(boolean por10) {
       this.por10=por10;
   }
   // Propiedad que si se vera en el area de bloques y nos dara el valor de la propiedad.
   @SimpleProperty (description="Multiplica por 10 o no")
   public boolean Get_por10() {
       return por10;
   }
}
