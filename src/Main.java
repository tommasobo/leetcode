public class Main {

    public static void main(String[] args) {

        String s = "loveleetcode";

        boolean foundAnother = false;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            foundAnother = false;
            for (int j = 0; j < s.length(); j++) {
                if ((charArray[i] == charArray[j]) && (i!=j)) {
                    foundAnother = true;
                }
            }

            if (!foundAnother) {
                System.out.println(i);
            }
        }

        System.out.println(-1);

    }
}
