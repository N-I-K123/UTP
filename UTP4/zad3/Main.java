package zad3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws IOException {
    URL url = new URL("http://wiki.puzzlers.org/pub/wordlists/unixdict.txt");
    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
    Map<String, List<String>> anagramMap = br
            .lines()
            .collect(Collectors.groupingBy(
                    str ->{
                      char [] arr = str.toCharArray();
                      Arrays.sort(arr);
                      return String.valueOf(arr);
                    },
                    ()->new LinkedHashMap<String, List<String>>(),
                    Collectors.toList()
            ));

    int sizeMax = anagramMap
            .values()
            .stream()
            .map(el -> el.size())
            .max(Integer::compare)
            .get();
    anagramMap
            .values()
            .stream()
            .filter(el -> el.size() == sizeMax)
            .forEach(el-> System.out.println(el.stream().collect(Collectors.joining(" "))));
  }
}
