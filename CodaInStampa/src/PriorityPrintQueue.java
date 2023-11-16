public class PriorityPrintQueue {
    public Nodo getTail(){
        return tail;
    }

    public void add(String value, int priority){
        Nodo nuovo = new Nodo(value, priority);
        if (head == null){
            head= nuovo;
            tail = head;
        }
        else {
            Nodo current =tail;
            Nodo save = tail;
            boolean cicla= true;
            int i=0;
            while (cicla){
                if ((current.getPriorita() > priority) || (current.getProssimo()==null)){
                    cicla= false;
                }else {
                    current = current.getProssimo();
                    i++;
                }
                if (current.getPriorita()> priority){
                    if (i==1){
                        nuovo.setProssimo(current);
                        tail= nuovo;
                    }else {
                        save.setProssimo(nuovo);
                        nuovo.setProssimo(current);
                    }
                }else {
                    nuovo.setProssimo(current.getProssimo());
                    current.setProssimo(nuovo);
                }
            }else{
                nuovo.setProssimo(current.getProssimo());
                current.setProssimo(nuovo);
            }

        }
    }
}
