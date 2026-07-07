package in.co.nmsworks.exam;

import java.util.List;
import java.util.Set;

public class StringCompression {
    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        String input = "aaabbca";

        System.out.println(stringCompression.compressString(input));

    }
    private String compressString(String input){
        String compressedString = "";
        int count = 1;
        List<Character> chars = null;


        compressedString += input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            char ch = input.charAt(i);
            if( input.charAt(i) == input.charAt(i - 1)){
                count ++;
            }
            else{
                compressedString += count;
                compressedString += ch;
                count = 1;
            }


        }

        return compressedString;
    }
}
