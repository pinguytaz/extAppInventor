package losejemplos.helpers;

import com.google.appinventor.components.common.OptionList;
import com.google.appinventor.components.common.Default;
import java.util.HashMap;
import java.util.Map;

public enum TipoEnum implements OptionList<Integer> {
  UnValor(0),
  ElUno(1),
  UnDo(2),
  Varios(3);

  private int tipoEnum;

  TipoEnum(int tipoEnum) {
    this.tipoEnum = tipoEnum;
  }

  public Integer toUnderlyingValue() {
    return tipoEnum;
  }

  private static final Map<Integer, TipoEnum> lookup = new HashMap<>();
  static {
    for(TipoEnum tipoEnum : TipoEnum.values()) {
      lookup.put(tipoEnum.toUnderlyingValue(), tipoEnum);
    }
  }

  public static TipoEnum fromUnderlyingValue(int tipoEnum) {
    return lookup.get(tipoEnum);
  }
}
