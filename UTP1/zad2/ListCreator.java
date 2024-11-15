
package zad2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ListCreator<T>{
    private List<T> sourceList;

    public ListCreator(List<T> sourceList) {
        this.sourceList = sourceList;
    }

    public static <T> ListCreator<T> collectFrom(List<T> list){
        return new ListCreator<>(list);
    }
    public ListCreator<T> when(Function<T, Boolean> selector) {
        List<T> resultList = new ArrayList<>();
        for (T item : this.sourceList) {
            if (selector.apply(item)) {
                resultList.add(item);
            }
        }
        this.sourceList = resultList;
        return this;
    }
    public <R> List<R> mapEvery(Function<T, R> mapper) {
        List<R> mappedList = new ArrayList<>();
        for (T item : this.sourceList) {
            mappedList.add(mapper.apply(item));
        }
        return mappedList;
    }
}
