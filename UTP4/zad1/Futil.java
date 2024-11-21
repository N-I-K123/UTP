package zad1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Futil {
    public static void processDir(String dirName, String resultFileName) {
        try{
            Path firstDir = Paths.get(dirName);
            Visitor visitor = new Visitor(Paths.get("./" + resultFileName));
            Files.walkFileTree(firstDir , visitor);
            visitor.clen();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
