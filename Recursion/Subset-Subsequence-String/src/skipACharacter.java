import java.util.*;
import java.lang.*;

public class skipACharacter {
    public static void main(String[] args) {
        String st1 = "baccad";
//        System.out.println(iterative(st1, 'a'));
        System.out.println(recursive(st1, 'a', new StringBuilder(), 0));
    }

    static StringBuilder iterative(String st, char skip) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);

            if (ch != skip) {
                sb.append(ch);
            }
        }

        return sb;
    }

    static StringBuilder recursive(String st, char skip, StringBuilder sb, int index) {
        if (index >= st.length()) {
            return sb;
        }

        char ch = st.charAt(index);
        if (ch != skip) {
            sb.append(ch);
        }

        return recursive(st, skip, sb, index + 1);
    }
}
