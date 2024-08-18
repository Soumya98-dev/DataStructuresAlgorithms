public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    //inserting at the head
    public void insertFirst(int val) {
        //1st creating a new node(a new box)
        Node node = new Node(val);
        //Pointing the next of the node to the head
        node.next = head;
        //head to the newly established node(because head always is the first node)
        head = node;

        //if there is only one element; then tail should be null
        if (tail == null) {
            tail = head;
        }

        size++;
    }

    //inserting at the tail
    public void insertEnd(int val) {
        // if tail is the first
        if (tail == null) {
            insertFirst(val);
        }
        //creating a new node
        Node node = new Node(val);
        //links the new node to the end of the linked list
        tail.next = node;
        //makes the newly inserted node the new tail
        tail = node;
        size++;
    }

    //inserting at any index
    public void insertAtIndex(int val, int index)
    {
        Node node = new Node(head.value);
//        while(index !=  )

    }

    //to display a linked list
    public void display() {
        Node temp = head; //a temporary variable pointing to head for displaying purpose
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next; //move the temp pointer
        }
        System.out.println("END");
    }

    private class Node {
        private int value;
        private Node next;//pointer is of node type 

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
