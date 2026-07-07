package in.co.nmsworks.Exam1;

import java.util.HashMap;
import java.util.Map;

public class CompressString {
    public static void main(String[] args) {
        CompressString c1=new CompressString();
        String value="aaabbca";
        System.out.println(c1.compressString(value));
    }

    private String compressString(String input){
        int count=1;
        String word="";

     for(int i=0;i<input.length()-1;i++) {
         if (input.charAt(i) == input.charAt(i + 1)) {
             count++;
         } else {
             word += count + "" + input.charAt(i);
             count = 1;
         }
     }
         word+= count +""+ input.charAt(input.length() - 1);
     return word;
    }
}
