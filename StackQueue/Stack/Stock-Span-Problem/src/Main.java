import java.util.*;

class Pair {
    int value;
    int index;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }

}

public class Main {
    public static void main(String[] args) {
//        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        int[] arr = {74, 665, 742, 512, 254, 469, 748, 445, 663, 758, 38, 60, 724, 142, 330, 779, 317, 636, 591, 243, 289, 507, 241, 143, 65, 249, 247, 606, 691, 330, 371, 151, 607, 702, 394, 349, 430, 624, 85, 755, 357, 641, 167, 177, 332, 709, 145, 440, 627, 124, 738, 739, 119, 483, 530, 542, 34, 716, 640, 59, 305, 331, 378, 707, 474, 787, 222, 746, 525, 673, 671, 230, 378, 374, 298, 513, 787, 491, 362, 237, 756, 768, 456, 375, 32, 53, 151, 351, 142, 125, 367, 231, 708, 592, 408, 138, 258, 288, 554, 784, 546, 110, 210, 159, 222, 189, 23, 147, 307, 231, 414, 369, 101, 592, 363, 56, 611, 760, 425, 538, 749, 84, 396, 42, 403, 351, 692, 437, 575, 621, 597, 22, 149, 800};

        int[] output = stockSpan(arr);
        System.out.println(Arrays.toString(output));
    }

    public static int[] stockSpan(int[] nums) {
        int[] index = new int[nums.length];//index for the greatest element
        int[] output = new int[nums.length];
        Stack<Pair> stack = new Stack<>();
        index[0] = -1;
        stack.push(new Pair(nums[0], 0));
        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek().value <= nums[i]) {
                stack.pop();
            }

            index[i] = stack.isEmpty() ? -1 : stack.peek().index;

            stack.push(new Pair(nums[i], i));
        }

        for (int i = 0; i < nums.length; i++) {
            output[i] = i - index[i];
        }

        return output;
    }
}
