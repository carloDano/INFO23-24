import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTesto {
    private String nomeFile;

    public FileTesto(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public void scriviSuFile(String testo) {
        try {
            BufferedWriter scrittore = new BufferedWriter(new FileWriter(nomeFile, true));
            scrittore.write(testo);
            scrittore.newLine();
            scrittore.close();
            System.out.println("Testo scritto con successo su " + nomeFile);
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura su " + nomeFile + ": " + e.getMessage());
        }
    }

    public void leggiDaFile() {
        try {
            BufferedReader lettore = new BufferedReader(new FileReader(nomeFile));
            String riga;
            System.out.println("Contenuto di " + nomeFile + ":");
            while ((riga = lettore.readLine()) != null) {
                System.out.println(riga);
            }
            lettore.close();
        } catch (IOException e) {
            System.err.println("Errore durante la lettura da " + nomeFile + ": " + e.getMessage());
        }
    }
}
