public class LinkedList {
    Node head ;
    public LinkedList () {
        head = null ;
    }
    public LinkedList ( int data ) {
        head = new Node ( data ) ;
    }


    public void insert ( int data ) {
        Node node = new Node ( data ) ;
        node . next = null ;
// the empty list
        if ( head == null ) {
            head = node ;
        }
        else {
            Node last = head ;
            while ( last . next != null ) {
                last = last . next ;
            }
// the last position
            last . next = node ;
        }
    }


    public String toString () {
        String s = " head -> " ;
        if ( head == null ) {
            s += " null " ;
            return s ;

        }
        Node node = head ;
        while ( node . next != null ) {
            s += node . data + " -> ";
            node = node . next ;
        }
        s += node . data + " -> null " ;
        return s ;
    }
}