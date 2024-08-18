import java.util.Stack;

public class Main{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = {1,2,3,4,5};
        for(int item: arr){
            stack.push(item);
        }
        System.out.println(stack);
        for(int item: arr){
            stack.pop();
        }
        System.out.println(stack);
    }
}