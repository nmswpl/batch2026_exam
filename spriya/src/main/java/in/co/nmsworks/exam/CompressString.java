package in.co.nmsworks.exam;

import java.util.HashMap;
import java.util.Map;

public class CompressString {

    public static void main(String[] args) {
        String ans = compressString("aabbca");
        System.out.println(ans);

    }

    private static String compressString(String input) {

        Map<Character, Integer> compress = new HashMap<>();

        StringBuilder ans = new StringBuilder();
        for (int j = 0; j < input.length(); j++) {
            int cnt = 1;
            char ch1 = input.charAt(j);



            int k = 1;
            char ch2 = input.charAt(k);
            while (k != input.length() && ch1 == ch2) {
                cnt++;
                k++;
            }


            int count = cnt;

            ans.append(String.valueOf(count));
            ans.append(ch1);

        }
        return ans.toString();
    }
}
