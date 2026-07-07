package in.co.nmsworks.exam;

import java.util.ArrayList;
import java.util.List;

public class StringCompression {

    public static void main(String[] args) {
        String input = "aabbbca";
        System.out.println("Result : " + compressString(input));
    }

    private static String compressString(String input) {

        String result = "";

        for (int i = 1; i < input.length(); i++) {
            int count = 1;
            if (input.charAt(i) != input.charAt(i-1)) {
                String res = String.valueOf(i)+input.charAt(i-1);
                result += res;
            }

        }

        return result;
    }
}
