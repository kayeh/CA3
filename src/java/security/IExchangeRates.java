package security;

import java.util.List;

public interface IExchangeRates {
  List<String>  getRatesAsStrings();
  String getCode();
  String getRate();
  String getDescription();
  String getDate();
}
