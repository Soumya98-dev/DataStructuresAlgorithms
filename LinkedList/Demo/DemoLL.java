import java.util.Objects;

public class DemoLL {

    Node head;
    private int size;

    DemoLL() {
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null; //because while we are creating a new node by default the next will be 'null'
            size++;
        }

    }

    public void addFirst(String val) {
        //Creating a new node
        Node newNode = new Node(val);

        //First check if linkedlist exits
        if (head == null)//this means there is no linkedlist
        {
            head = newNode;
            return;
        }

        newNode.next = head;//pointing newnode's next towards the head node
        head = newNode;  //making newnode the head

    }

    public void addLast(String val) {
        //make a new node 
        Node newNode = new Node(val);
        //First check if linkedlist exits
        if (head == null)//this means there is no linkedlist
        {
            head = newNode;
            return;
        }
        //making a new temporary node and point it to the head; NEVER MANIPULATE THE HEAD NODE
        Node tempNode = head;
        //increment the head, till it is not null
        //checking after incrementing that the 'tempNode's' next is pointing to null
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        //as we reach the last node, point the next of the last node to the new node
        tempNode.next = newNode;

    }

    public void addInMiddle(int index, String data) {
        //creating a new node
        Node newNode = new Node(data);

        //invalid index value
        if (index > size || index < 0) {
            return;
        }

        //If there is no linkedlist and the index is 0
        if (head == null || index == 0) {
            newNode.next = head;
            newNode = head;
        }

        //for any normal linkedlist
        Node currNode = head;
        for (int i = 1; i < size; i++) {
            if (i == index) {
                Node nextNode = currNode.next;
                currNode.next = newNode;
                newNode.next = nextNode;
                break;
            }

            currNode = currNode.next;
        }

    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }
        size--;
        //the delete node; java garbage collector takes it away 
        //Make the next of the head as the new head 
        //points heads next to it's next node
        head = head.next;
    }

    public void deleteLast() {
        //traverse the head node
        //stop at the second-last node and make the next of the second last node as null; so it will break the connection with the last node
        if (head == null) {
            return;
        }
        size--;
        //if while deletion there is only one node(which is head)
        if (head.next == null) {
            head = null;
            return;
        }

        Node tempNode = head;
        while (tempNode.next.next != null) {
            tempNode = tempNode.next;
        }

        tempNode.next = null;


    }

    public void reverse(Node head) {
        Node curr = head;
        Node next = curr.next;
        Node prev = null;

        while (curr.next != null) {
            if (curr == head) {
                curr.next = null;
            }
            curr.next = prev;
            curr = next;
            next = curr.next;
        }
    }

    public void display() {
        //traverse the whole linkedlist using the temporary node
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.next;
        }

        System.out.println("null");

    }

    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public void duplicates() {
        Node node = head;
        if (head == null) {
            return;
        }

        while (node.next != null) {
            if (node.data.equals(node.next.data)) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
    }

    public static void main(String[] args) {
        DemoLL demoLL = new DemoLL();
//        demoLL.addFirst("a");
//        demoLL.addFirst("is");
//        demoLL.display();
//        demoLL.addLast("list");
//        demoLL.display();
        // demoLL.deleteFirst();
        // demoLL.display();
        // demoLL.deleteLast();
        // demoLL.display();
        demoLL.addFirst("shradha");
        demoLL.addFirst("name");
        demoLL.addFirst("my");
//        demoLL.display();
        System.out.println(demoLL.getSize());
        demoLL.addInMiddle(2, "is");
        demoLL.addFirst("my");
        demoLL.display();
        System.out.println(demoLL.getSize());
//        System.out.println(demoLL.reverse(demoLL.head));
//        demoLL.duplicates();
//        demoLL.display();

    }
}