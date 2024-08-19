/*************************************************************
 *  Autor: Fco. Javier Rodriguez Navarro
 *  WEB: www.pinguytaz.net
 *
 *  Descripción: Clase de apoyo a Logs, que nos permite tener una enumeración de
 *  los tipos de mensajes.
 * 
 *  Version 1.0 Agosto 2024
 **********************************************************/
package pinguytaz.net.utiles.helpers;

import com.google.appinventor.components.common.OptionList;
import com.google.appinventor.components.common.Default;
import java.util.HashMap;
import java.util.Map;

public enum TiposLog implements OptionList<Integer> {
  Verbose(0),
  Debug(1),
  Info(2),
  Advertencia(3),
  Error(4);

  private int tipoLog;
   TiposLog(int tipoLog) {
    this.tipoLog = tipoLog;
  }

  public Integer toUnderlyingValue() {
    return tipoLog;
  }

  private static final Map<Integer, TiposLog> lookup = new HashMap<>();
  static {
    for(TiposLog tipoLog : TiposLog.values()) {
      lookup.put(tipoLog.toUnderlyingValue(), tipoLog);
    }
  }

  public static TiposLog fromUnderlyingValue(int tipoLog) {
    return lookup.get(tipoLog);
  }
}

