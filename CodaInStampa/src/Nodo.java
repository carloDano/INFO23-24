public class Nodo {
    private String valore;
    private int priorita;
    private Nodo prossimo;

    public Nodo(String valore, int priorita, Nodo prossimo) {
        this.valore = valore;
        this.priorita = priorita;
        this.prossimo = prossimo;
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }

    public int getPriorita() {
        return priorita;
    }

    public void setPriorita(int priorita) {
        this.priorita = priorita;
    }

    public Nodo getProssimo() {
        return prossimo;
    }

    public void setProssimo(Nodo prossimo) {
        this.prossimo = prossimo;
    }
}
