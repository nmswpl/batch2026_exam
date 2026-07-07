package in.co.nmsworks.exam;

import java.util.HashMap;
import java.util.Map;

public class CompressString {
    public static void main(String[] args) {
        CompressString compressString = new CompressString();
        String string = compressString.compressString("aaabbca");
        System.out.println("Compressed String: "+string);
    }

    private String compressString(String input) {
        String answer1 = "";
        int count = 1;
        int n = input.length();
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i+1)) {
                count ++;
            }
            else {
                answer1 += count;
                answer1 += input.charAt(i);
                count = 1;

            }
        }
        if (input.charAt(n-1) != input.charAt(n-2) )
        {
            answer1 += 1;
            answer1 += input.charAt(n-1);
        }
        System.out.println("NEw compressed string "+answer1);

        return answer1;
    }
}
