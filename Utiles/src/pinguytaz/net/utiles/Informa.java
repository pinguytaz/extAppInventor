/*************************************************************
 *  Autor: Fco. Javier Rodriguez Navarro
 *  WEB: www.pinguytaz.net
 *
 *  Descripción: Nos da información del dispositivo y la aplicación con propiedades
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
import com.google.appinventor.components.annotations.SimpleProperty;

// Importacion de librerias Android
import android.util.Log; // Clase del API android para generar LOG
//import android.content.pm.ApplicationInfo;    // Informacion de la aplicacion.
import android.os.Build;

// Importacion de otras librerias


// Descripcion de la extension
@DesignerComponent(version = 1,
                    category = ComponentCategory.EXTENSION,
                    description = "Informaciones de dispositivo y aplicacion",
                    nonVisible = true,
                    iconName = "aiwebres/LogoPingu.png")
@SimpleObject(external = true)

// Definimos la clase publica de nuestra extension
public class Informa extends AndroidNonvisibleComponent {

    public Informa(ComponentContainer container) {
        super(container.$form());
    }   

  // Propiedades de solo lectura
  @SimpleProperty(description = "Nombre de la plataforma")
  public String NombrePlataforma() {
     return Build.BOARD;
  }

  @SimpleProperty()
  public String Marca() {
     return Build.BRAND;
  }
  @SimpleProperty()
  public String DEVICE() {
     return Build.DEVICE;
  }

  @SimpleProperty()
  public String Huella() {
     return Build.FINGERPRINT;
  }
  @SimpleProperty()
  public String Hardware() {
     return Build.HARDWARE;
  }
  @SimpleProperty()
  public String HOST() {
     return Build.HOST;
  }
  @SimpleProperty()
  public String ID() {
     return Build.ID;
  }
  @SimpleProperty()
  public String Fabricante() {
     return Build.MANUFACTURER;
  }
  @SimpleProperty()
  public String Modelo() {
     return Build.MODEL;
  }
  @SimpleProperty()
  public String Producto() {
     return Build.PRODUCT;
  }
  @SimpleProperty()
  public int VERSION_SDK_EnNumero() {
     return Build.VERSION.SDK_INT;
  }
  @SimpleProperty()
  public String VERSION_SDK() {
     int sdk = Build.VERSION.SDK_INT;
     switch (sdk) {
        case 1:
           return "APPLE PIE 1.0 API-4";
        case 2:
           return "BANANA BREAD 1.1 API-4";
        case 3:
           return "CUPCAKE 1.5 API-4";
        case 4:
           return "DONUT 1.6 API-4";
        case 5:
           return "ECLAIR 2.0 API-5";
        case 6:
           return "ECLAIR 2.0.1 API-6";
        case 7:
           return "ECLAIR 2.1 API-7";
        case 8:
           return "FROYO 2.2 API-8";
        case 9:
           return "GINGERBREAD 2.3 API-9";
        case 10:
           return "GINGERBREAD 2.3.3 API-10";
        case 11:
           return "HONEYCOMB 3.0 API-11";
        case 12:
           return "HONEYCOMB 3.1 API-12";
        case 13:
           return "HONEYCOMB 3.2 API-13";
        case 14:
           return "ICE CREAM SANDWICH 4.0 API-14";
        case 15:
           return "ICE CREAM SANDWICH 4.03 API-15";
        case 16:
           return "JELLY BEAN 4.1 API-16";
        case 17:
           return "JELLY_BEAN 4.2 API-17";
        case 18:
           return "JELLY_BEAN 4.3 API-18";
        case 19:
           return "KITKAT 4.4 API-19";
        case 20:
           return "KITKAT 4.4.4 API-20";
        case 21:
           return "LOLLIPOP 5.0 API-21";
        case 22:
           return "LOLLIPOP 5.1 API-22";
        case 23:
           return "Macadamia Nut Cookie 6.0 API-23";
        case 24:
           return "New York Cheesecake 7.0 API-24";
        case 25:
           return "New York Cheesecake 7.1 API-25 ";
        case 26:
           return "Oatmeal Cookies 8.0 API-26";
        case 27:
           return "Oatmeal Cookies 8.1 API-27";
        case 28:
           return "Pistacho Ice Cream 9 API-28";
        case 29:
           return "Quince Tart 10 API-29";
        case 30:
           return "Red Velvet Cake 11 API-30";
        case 31:
           return "Snow Cone 12 API-31";
        case 32:
           return "Snow Cone 12L API-32";
        case 33:
           return "TIRAMISU 13 API-33";
        case 34:
           return "UPSIDE DOWN CAKE 14 API-34";
        case 35:
           return "VANILLA ICE CREAM 15 API-35";
        default:
           return "Desconocido (Ultima registrada Vainilla API35)";
     }
  }

  @SimpleProperty()
  public String Version_Interna() {
     return Build.VERSION.INCREMENTAL ;
  }
  @SimpleProperty()
  public String Parche_Seguridad() {
     return Build.VERSION.SECURITY_PATCH ;
  }
}
