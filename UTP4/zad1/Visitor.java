package zad1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class Visitor implements FileVisitor<Path> {
    private BufferedWriter bw;
    public Visitor(Path outPath) throws IOException{
        System.out.println(outPath);
        bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(
                                outPath.toFile()
                        ),
                        StandardCharsets.UTF_8
                )
        );
    }
    public void clen() throws IOException{
        bw.close();
    }
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                file.toString()),
                        "cp1250"
                )
        );
        String line;
        while ((line = br.readLine())!=null){
            bw.write(line);
            bw.newLine();
        }
        br.close();
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}
