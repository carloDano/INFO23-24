public class Pila {
    private Nodo cima;

    public Pila() {
        cima = null;
    }

    public void push(char valore) {
        Nodo nuovoNodo = new Nodo(valore);
        nuovoNodo.prossimo = cima;
        cima = nuovoNodo;
    }

    public char pop() {
        if (isEmpty()) {
            throw new IllegalStateException("La pila è vuota.");
        }
        char valore = cima.valore;
        cima = cima.prossimo;
        return valore;
    }

    public boolean isEmpty() {
        return cima == null;
    }
}
