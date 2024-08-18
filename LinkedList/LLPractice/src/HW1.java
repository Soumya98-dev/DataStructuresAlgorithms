import java.util.*;

public class HW1 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] arr = {1, 5, 7, 3 , 8, 2, 3};

        for (int j : arr) {
            list.add(j);
        }

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == 7){
                System.out.println(i);
                break;
                
            }
        }

        System.out.println(list);

    }
}
