package pinguytaz.net.logs.helpers;

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

