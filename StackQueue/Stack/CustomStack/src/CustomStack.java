public class CustomStack {
    protected int[] data;

    /*In Java, when a variable is declared as static and final, it is considered a constant, and its value cannot be changed after it is initialized*/
    private static final int DEFAULT_SIZE = 10;
    //The ptr variable, initialized to -1, suggests that the stack is initially empty.
    int ptr = -1;//keep track of the top element in the stack.

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return ptr == this.data.length - 1;//ptr at last index
    }

    public boolean isEmpty() {
        return ptr == -1; //stack is empty
    }

    public boolean push(int item) {
        if (isFull()) {
            System.out.println("Stack is full");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }

        int removed = data[ptr];
        ptr--;
        return removed;
    }
}
