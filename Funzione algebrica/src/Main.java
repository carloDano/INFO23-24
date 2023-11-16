public class Main {
    public static boolean parentesiCorrette(String espressione) {
        Pila pila = new Pila();

        for (char carattere : espressione.toCharArray()) {
            if (carattere == '(' || carattere == '[' || carattere == '{') {
                pila.push(carattere);
            } else if (carattere == ')' || carattere == ']' || carattere == '}') {
                if (pila.isEmpty()) {
                    return false;
                }

                char parentesiApertura = pila.pop();
                if (!corrispondono(parentesiApertura, carattere)) {
                    return false;
                }
            }
        }

        return pila.isEmpty();
    }

    private static boolean corrispondono(char apertura, char chiusura) {
        return (apertura == '(' && chiusura == ')') ||
                (apertura == '[' && chiusura == ']') ||
                (apertura == '{' && chiusura == '}');
    }

    public static void main(String[] args) {
        String espressione1 = "ab(ax) { [(b)du (mb)]}";
        String espressione2 = "a(ax)[c";
        String espressione3 = "a){b(e}";
        String espressione4 = "a{[bc}]";

        System.out.println("Espressione 1: " + parentesiCorrette(espressione1));
        System.out.println("Espressione 2: " + parentesiCorrette(espressione2));
        System.out.println("Espressione 3: " + parentesiCorrette(espressione3));
        System.out.println("Espressione 4: " + parentesiCorrette(espressione4));
    }
}
