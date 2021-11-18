public class IDedLinkedList<AnyType extends IDedObject> {
    private Node start; //header node
    private int size; //size of list

    //constructor
    public IDedLinkedList() {
        start = null;
        size = 0;
    }

    //empties the list
    public void makeEmpty() {
        start = null;
        size = 0;
    }

    //get the generic type to get the particular id and returns AnyType, returns null if list is empty or ID is not found
    public AnyType findID(int ID) {
        Node nptr = start;

        while(nptr != null) {
            if(nptr.getData().getID() == ID)
                return nptr.getData();
            else   
                nptr = nptr.getLink();
        }

        return null;
    }

    //insert at front of list or return false if that ID already exists
    public boolean insertAtFront(AnyType x) {
        Node node = new Node(x, null);

        //if list is empty, insert x and return true
        if(start == null) {
            start = node;
            size++;
            return true;
        }

        Node nptr = start;

        while(nptr != null) {
            //if ID already exists in the list return false
            if(nptr.getData().getID() == x.getID())
                return false;
            else
                nptr = nptr.getLink();
        }

        //ID not already in the list, insert x at the front and return true
        node.setLink(start);
        start = node;
        size++;

        return true;
    }

    //delete and return the record at the front of the list or return null if the list is empty
    public AnyType deleteFromFront() {
        if(start == null)
            return null;
        
        AnyType x = start.getData();
        start = start.getLink();
        size--;
        return x;
    }

    //find and delete the record with the given ID or returns null if it isn't found
    public AnyType delete(int ID) {
        if(start == null)
            return null;
        
        if(start.getData().getID() == ID) {
            AnyType x = start.getData();
            start = start.getLink();
            size--;
            return x;
        }

        AnyType x = null;
        Node ptr = start;
        Node nptr = start.getLink();

        while(nptr != null) {
            if(nptr.getData().getID() == ID) {
                x = nptr.getData();
                ptr.setLink(nptr.getLink());
                size--;
                break;
            }
            else {
                ptr = nptr;
                nptr = nptr.getLink();
            }
        }

        return x;
    }

    //return the sum of ids of all elements currently in the list, if list is empty return -1
    public int printTotal() {
        if(start == null)
            return -1;

        int total = 0;
        Node nptr = start;
        
        while(nptr != null) {
            total += nptr.getData().getID();
            nptr = nptr.getLink();
        }

        return total;
    }

    //private inner node class
    private class Node{
        private AnyType data;
        private Node link;

        Node(AnyType data, Node link) {
            this.data = data;
            this.link = link;
        }

        public AnyType getData() {
            return data;
        }

        public Node getLink() {
            return link;
        }

        public void setLink(Node link) {
            this.link = link;
        }
    }
}
