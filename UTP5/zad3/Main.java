package zad3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

  public static void main(String[] args) {
    String fileName = "../Towary.txt";
    BlockingQueue<Towar> queue = new LinkedBlockingQueue<>();
    Thread readerThread = new Thread(new Reader(fileName,queue));
    readerThread.start();
    Thread weightThread = new Thread(new WeightCalculator(queue));
    weightThread.start();

  }
}
