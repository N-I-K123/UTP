

package zad2;


import java.util.*;

public class Main {

  static List<String> getPricesInPLN(List<String> destinations, double xrate) {
    return ListCreator.collectFrom(destinations)
                       .when((String str)-> str.startsWith("WAW"))
                       .mapEvery((String str)->{
                         String[] s = str.split(" ");
                         Integer price = Integer.parseInt(s[2]);
                         Integer pricePln = (int) (price* xrate);
                         return String.format("to %s - price in PLN: %d", s[1], pricePln);
                       });
  }

  public static void main(String[] args) {
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = getPricesInPLN(dest, ratePLNvsEUR);
    for (String r : result) System.out.println(r);
  }
}
