package zad3;

import java.util.concurrent.BlockingQueue;

public class WeightCalculator implements Runnable{

    private BlockingQueue<Towar> queue;
    private int objectsCount;

    public WeightCalculator(BlockingQueue<Towar> queue) {
        this.queue = queue;
        this.objectsCount = 0;
    }

    @Override
    public void run() {
        int totalWeight = 1;
        try{
            while (true){
                Towar towar = queue.take();
                totalWeight+=towar.getWaga();
                objectsCount++;
                if (objectsCount%100 == 0){
                    System.out.println("policzono wage " + objectsCount + " towarów");
                }
                if (towar.getWaga() == -1 && towar.getId() == -1){
                    System.out.println("sumaryczna waga = " + totalWeight);
                    break;
                }
            }
        } catch (InterruptedException e){
            System.err.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
