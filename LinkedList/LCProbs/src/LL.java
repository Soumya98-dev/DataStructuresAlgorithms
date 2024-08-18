public class LL {

    private Node head;
    public int size;

    LL() {
    }

    public class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
            size++;
        }


    }

    public void addFirst(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int val) {
        //Creating a new node
        Node newNode = new Node(val);

        Node currNode = head;

        //edge cases
        //checking if linkedlist exists
        if (head == null) {
            addFirst(val);
        }
        while (currNode != null) {
            if (currNode.next == null) {
                currNode.next = newNode;
                break;
            }
            currNode = currNode.next;
        }

    }

    //    https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
    public void duplicates() {
        Node node = head;

        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
    }

    //    https://leetcode.com/problems/merge-two-sorted-lists/
    public static LL mergeTwoLists(LL list1, LL list2) {
        Node first = list1.head;
        Node second = list2.head;

        LL ans = new LL();

        while (first != null) {
            if (first.val <= second.val) {
                ans.addLast(first.val);
                first = first.next;
            } else {
                ans.addLast(second.val);
                second = second.next;
            }
        }
        while (second != null) {
            ans.addLast(second.val);
            second = second.next;
        }
        return ans;
    }

    //https://leetcode.com/problems/linked-list-cycle/description/
    public boolean hasCycle(LL list) {
        //edge cases
        // if only 1 node present; then no cycle
        if (head.next == null) {
            return false;
        }

        Node slowPtr = list.head;
        Node fastPtr = list.head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                return true;
            }
        }

        return false;
    }

    public int lengthOfCycle(LL list) {
        if (head.next == null) {
            return 0;
        }
        int count = 0;
        Node slowPtr = list.head;
        Node fastPtr = list.head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                Node temp = slowPtr;
                do {
                    count++;
                    temp = temp.next;
                } while (temp != fastPtr);
            }
            return count;
        }

        return 0;
    }

    //    https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        //finding the length of the cycle
        int length = 0;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                ListNode temp = slowPtr;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slowPtr);
                break;
            }
        }

        //if there is no cycle
        if (length == 0) {
            return null;
        }

        //finding the second node(moving it to the end of the list)
        ListNode first = head;
        ListNode second = head;

        while (length > 0) {
            second = second.next;
            length--;
        }

        //moving both first and second pointer till they are at the same place(which is the starting point of the cycle)
        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return second;
    }

    //https://leetcode.com/problems/happy-number/
    public boolean isHappy(int n) {
        if(n <= 0){
            return false;
        }

        int fast = n;
        int slow = n;

        do{
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));

        }while(slow != fast);

        if(slow == 1){
            return true;
        }
    }

    private int sumOfSquares(int n){
        int ans = 0;
        while(number > 0){
            int lastDigit = number % 10;
            ans += lastDigit * lastDigit;
            number /= 10;
        }
        return ans;
    }

    //https://leetcode.com/problems/middle-of-the-linked-list/
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public void display() {
        Node tempNode = head;

        while (tempNode != null) {
            System.out.print(tempNode.val + "->");
            tempNode = tempNode.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        LL list = new LL();
        int[] arr = {3, 2, 0, -4};
        for (int j : arr) {
            list.addLast(j);
        }
        list.display();
        System.out.println(list.hasCycle(list));

    }
}