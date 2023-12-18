import java.io.BuffertedReader;
import java.io.FileReader;
import java.io.IOException;

public class TranslatorApp {
    public static void main(String[] args) {
        BinarySearchTree dictionary = loadDictionary("dictionary.csv");

        if (dictionary == null) {
            System.out.println("Errore durante il caricamento del dizionario.");
            return;
        }

        System.out.println("Dizionario caricato con successo.");

        while (true) {
            System.out.println("Seleziona un'opzione:");
            System.out.println("1. Traduci da inglese a italiano");
            System.out.println("2. Traduci da italiano a inglese");
            System.out.println("3. Esci");

            int choice = ConsoleInput.getIntInput();

            switch (choice) {
                case 1:
                    System.out.print("Inserisci la parola in inglese da tradurre: ");
                    String wordToTranslate = ConsoleInput.getStringInput();
                    String translation = dictionary.search(wordToTranslate.toLowerCase());
                    System.out.println("Traduzione: " + translation);
                    break;

                case 2:
                    System.out.print("Inserisci la parola in italiano da tradurre: ");
                    String wordToTranslateIT = ConsoleInput.getStringInput();
                    // Ricerca inversa nel dizionario
                    String translationIT = searchItalianWord(dictionary.root, wordToTranslateIT.toLowerCase());
                    System.out.println("Traduzione: " + translationIT);
                    break;

                case 3:
                    System.out.println("Uscita dal programma.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        }
    }

    private static BinarySearchTree loadDictionary(String fileName) {
        BinarySearchTree dictionary = new BinarySearchTree();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String englishWord = parts[0].trim().toLowerCase();
                    String italianTranslation = parts[1].trim().toLowerCase();
                    dictionary.insert(englishWord, italianTranslation);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return dictionary;
    }

    private static String searchItalianWord(TreeNode root, String italianWord) {
        if (root == null) {
            return "Traduzione non trovata";
        }

        if (italianWord.equals(root.value.toLowerCase())) {
            return root.key;
        }

        String leftResult = searchItalianWord(root.left, italianWord);
        String rightResult = searchItalianWord(root.right, italianWord);

        return !leftResult.equals("Traduzione non trovata") ? leftResult : rightResult;
    }
}