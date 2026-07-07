package in.co.nmsworks.exam;

import java.util.HashMap;
import java.util.Map;

public class CompressString {
    public static void main(String[] args) {
        String string = "aaabbcc";
        String outputString = "";
        int count = 1;
        for (int i = 1; i < string.length(); i++) {
            char ch = string.charAt(i);
            for (int j = 0; j < string.length(); j++) {
                if (ch == string.charAt(j)){
                    count++;
                    break;
                }
            }
            outputString += String.valueOf(count) + string.charAt(i);
        }
        System.out.println(outputString);
    }
}
