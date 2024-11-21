package zad3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class Reader implements Runnable{
    private String fileName;
    private BlockingQueue<Towar> queue;
    private int objectsCount;
    public Reader(String fileName, BlockingQueue<Towar> queue) {
        this.fileName = fileName;
        this.queue = queue;
        this.objectsCount = 0;
    }

    @Override
    public void run() {
        try{
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine())!=null){
                String [] parts = line.split(" ");
                if (parts.length == 2){
                    int id = Integer.parseInt(parts[0]);
                    int waga = Integer.parseInt(parts[1]);
                    Towar towar = new Towar(id, waga);
                    queue.put(towar);
                    if (objectsCount%200 == 0){
                        System.out.println("utworzono " + objectsCount + " obiektów");
                    }
                    objectsCount++;
                }
            }
            br.close();
            queue.put(new Towar(-1,-1));
        }catch (IOException | InterruptedException e){
            System.err.println(e.getMessage());
        }
    }
}
