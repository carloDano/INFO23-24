public class Main {
    public static void main(String[] args) {
        // Test della classe FileTesto
        FileTesto fileDiTesto = new FileTesto("test.txt");

        // Scriviamo alcune righe di testo nel file
        fileDiTesto.scriviSuFile("Questa è la prima riga.");
        fileDiTesto.scriviSuFile("Questa è la seconda riga.");
        fileDiTesto.scriviSuFile("Questa è la terza riga.");


        // Leggiamo e stampiamo il contenuto del file
        fileDiTesto.leggiDaFile();
    }
}