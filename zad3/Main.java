
package zad3;


import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = dest
            .stream()
            .filter((String str)->str.startsWith("WAW"))
            .map((String str)->{
                String[] s = str.split(" ");
                Integer price = Integer.parseInt(s[2]);
                Integer pricePln = (int) (price* ratePLNvsEUR);
                return String.format("to %s - price in PLN: %d", s[1], pricePln);
            })
            .collect(Collectors.toList());

    for (String r : result) System.out.println(r);
  }
}
