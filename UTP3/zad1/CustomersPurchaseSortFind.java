package zad1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;

public class CustomersPurchaseSortFind {
    private ArrayList<Purchase> records;
    private Comparator<Purchase> getFilter(String fName){
        if (fName.equals("Nazwiska")){
            return (el1, el2) -> {
                int diff = el1.surname.compareTo(el2.surname);

                if (diff == 0) {
                    return el1.id.compareTo(el2.id);
                }

                return diff;
            };
        }
        if (fName.equals("Koszty")) {
            return (el1, el2) -> {
                int diff = (int) Math.ceil(el2.getCost() - el1.getCost());

                if (diff == 0) {
                    return el1.id.compareTo(el2.id);
                }

                return diff;
            };
        }

        return (el1, el2) -> 0;
    }
    public void readFile(String fname) {
        this.records = new ArrayList<Purchase>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fname));

            String line;

            while((line = br.readLine()) != null) {
                this.records.add(new Purchase(line));
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showSortedBy(String filterName) {
        System.out.println(filterName);

        this.records
                .stream()
                .sorted(this.getFilter(filterName))
                .forEach(p -> System.out.println(
                        p.toString(
                                filterName.equals("Koszty")
                        )
                ));

        System.out.println("");
    }
    public void showPurchaseFor(String id) {
        System.out.println("Klient " + id);

        this.records
                .stream()
                .filter((p) -> p.id.equals(id))
                .forEach(p -> System.out.println(p));

        System.out.println("");
    }
}
