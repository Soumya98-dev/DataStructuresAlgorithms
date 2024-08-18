public class SkipAString {
    public static void main(String[] args) {
        String st = "bcdapplefg";
        String skip = "apple";

//        System.out.println(iterative(st, skip));
        System.out.println(recursive(st, skip, new StringBuilder(), 0));
    }

    static StringBuilder iterative(String st, String skip) {
        StringBuilder sb = new StringBuilder();

        int indexSkipStr = st.indexOf(skip);//-1 if skip string not present
        int lastIndex = 0;

        while (indexSkipStr != -1) {
            sb.append(st, lastIndex, indexSkipStr);
            lastIndex = indexSkipStr + skip.length();
            indexSkipStr = st.indexOf(skip, lastIndex);
        }

        return sb.append(st.substring(lastIndex));
    }

    static StringBuilder recursive(String st, String skip, StringBuilder sb, int lastIndex) {
        int indexSkipStr = st.indexOf(skip, lastIndex);

        if (indexSkipStr == -1) {
            return sb.append(st.substring(lastIndex));
        }

        sb.append(st, lastIndex, indexSkipStr);

        return recursive(st, skip, sb, indexSkipStr + skip.length());
    }
}
