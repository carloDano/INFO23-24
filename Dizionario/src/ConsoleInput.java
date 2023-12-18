class ConsoleInput {
    private static final java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Inserisci un numero valido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static String getStringInput() {
        return scanner.next();
    }
}