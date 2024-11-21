package zad2;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe <T>{
    T input;

    public Maybe(){}
    public Maybe(T input) {
        this.input = input;
    }
    public static <U> Maybe<U> of(U value){
        return new Maybe(value);
    }
    public void ifPresent(Consumer cons){
        if (input!=null){
            cons.accept(input);
        }
    }
    public <U>Maybe<U> map(Function<T, U> func){
        if (input!=null) {
            return new Maybe((U) func.apply(input));
        } else {
            return new Maybe();
        }
    }
    public T get() throws NoSuchElementException{
        if (input == null){
            throw new NoSuchElementException("maybe is empty");
        }
        return input;
    }
    public boolean isPresent(){
        if (input==null){
            return false;
        }
        return true;
    }
    public T orElse(T defVal){
        return input != null ? input : defVal;
    }
    public Maybe <T> filter(Predicate<T> pred){
        if (pred.test((T)this.input) || input==null){
            return this;
        }else {
            return new Maybe();
        }
    }

    @Override
    public String toString() {
        if (input!=null){
            return "Maybe has value " + input.toString();
        }else {
            return "maybe is empty";
        }
    }
}
