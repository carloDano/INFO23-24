import java.util.HashSet;

public class Insieme {

    private HashSet<Integer> set;

    public Insieme() {
        set = new HashSet<>();
    }

    // Metodo per inserire un valore nel nuovo insieme
    public void insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            System.out.println("Valore " + val + " inserito nell'insieme.");
        } else {
            System.out.println("Il valore " + val + " è già presente nell'insieme.");
        }
    }

    // Metodo per eliminare un valore dall'insieme
    public void delete(int val) {
        if (set.contains(val)) {
            set.remove(val);
            System.out.println("Valore " + val + " eliminato dall'insieme.");
        } else {
            System.out.println("Il valore " + val + " non è presente nell'insieme.");
        }
    }
}
