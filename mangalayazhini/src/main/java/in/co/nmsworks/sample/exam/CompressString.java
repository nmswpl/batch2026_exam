package in.co.nmsworks.sample.exam;

import java.util.HashMap;
import java.util.Map;

public class CompressString {
    public static void main(String[] args) {

        CompressString compressStrObj = new CompressString();
        compressStrObj.compressString("aaabb");
    }

    private String compressString(String input){

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = Character.valueOf(input.charAt(i));

            if(charCountMap.get(ch) == null){
                charCountMap.put(ch,1);
            }
            else{
                Integer count = charCountMap.get(ch);
                count++;
                charCountMap.put(ch,count);
            }
        }

        String compressedStr = "";
        for (Character c : charCountMap.keySet()) {
            System.out.println(c + " : " + charCountMap.get(c));

            compressedStr += String.valueOf(charCountMap.get(c));
            compressedStr += c;
        }

        System.out.println("compressed str : " + compressedStr);
        return null;
    }

}
