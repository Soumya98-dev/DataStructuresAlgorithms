public class Main {
    public static void main(String[] args) {

        LL ll = new LL();
        ll.insertFirst(7);
        ll.insertFirst(10);
        ll.insertFirst(2);
        ll.insertFirst(17);
        ll.display();
        ll.insertEnd(14);
        ll.display();
        ll.insertAtIndex(0,0);
    }
}