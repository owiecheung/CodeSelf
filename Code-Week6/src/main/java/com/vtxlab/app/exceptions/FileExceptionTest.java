package com.vtxlab.app.exceptions;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileExceptionTest {
  
  //Checked Exception
  public static void main(String[] args)  throws IOException{
    List<String> lines = new ArrayList<>();
    try{
    Path filePath = Paths.get("/Users/owiecheung/Code/CodeSelf/Code-Week6/src/main/java/com/vtxlab/app/someFile.txt");
    lines =Files.readAllLines(filePath);
   // boolean deleteCompleted = Files.deleteIfExists(filePath);
   String str = "OOvevbrr";
   byte[] strToBytes = str.getBytes();
    Files.write(filePath, strToBytes, StandardOpenOption.APPEND);
    }
    catch(IOException e){
      Path filePath = Paths.get("/Users/owiecheung/Code/CodeSelf/Code-Week6/src/main/java/com/vtxlab/app/backFile.txt");
      lines =Files.readAllLines(filePath);
    } finally{
      System.out.println(lines);
    }


  }
}
