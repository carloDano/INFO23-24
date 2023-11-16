import org.w3c.dom.Node;

import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        int numFile = random.nextInt(10);
        for (int i=0; i<numFile; i++){
            File file= new File("file"+ String.format("%03d", i)+".txt");
            file.createFile();
            int numrighe = random.nextInt(30);
            for (int j=0; j<numFile; j++){
                file.println("righa"+ String.format("%03d", j));
            }
            file.flush();
            file.closeW();
        }

        PriorityPrintQueue codaStampa = new PriorityPrintQueue();
        for (int i=0; i<numFile; i++){
            File file = new File("File" +String.format("%03d",i) +".txt");
            file.openFile();
            String righe = "";
            String s = file.readln();
            int numParole = 0;
            while (s!=null){
                righe = righe + s+"\n";
                String[] nomi = s.split(" ");
                numParole = numParole+nomi.length;
                s=file.readln();
            }
            file.closeR();
            codaStampa.add(righe, numParole);
        }

        String contenuto="";
        Node current = codaStampa.getTail();
        while (current!=null){
            contenuto = contenuto +" +++++ " + String.format("%03d", current.getPriority())+ " +++++ ";
            contenuto = contenuto + "\n";
            contenuto = contenuto + current.getValue;
            contenuto = contenuto + "\n";
            current = current.getNext();
        }
        print.println(contenuto);
        print.closeW();
    }
}