package in.co.nmsworks.exam;

import java.util.HashMap;
import java.util.Map;

public class CompressStringClass {
    public static void main(String[] args) {
        CompressStringClass compressStringClass = new CompressStringClass();
        String str = "aabbc";
        String compressedString = compressStringClass.compressString(str);
        System.out.println(compressedString);
    }

//    private String compressString(String str) {
//        Map<Character, Integer> frequency = new HashMap<>();
//        for (int i = 0; i < str.length(); i++){
//            char ch = str.charAt(i);
//            Integer count = frequency.get(ch);
//            if (frequency.get(ch) == null){
//                frequency.put(ch, 1);
//            } else {
//                frequency.put(ch, count+1);
//
//            }
//        }
//        String compressedString = "";
//        for (Map.Entry<Character, Integer> characterIntegerEntry : frequency.entrySet()) {
//            for (int i = 0; i < characterIntegerEntry.getKey(); i++){
//                compressedString += characterIntegerEntry.getValue();
//            }
//        }
//        return compressedString;
//    }


    private String compressString(String str) {
        String compressedString = "";
        int strLength = str.length();
        int counter = 1;
        for (int i = 0; i < strLength-1; i++){
            if ((str.charAt(i+1) == str.charAt(i))){
                counter++;
            }
            String counterString = String.valueOf(counter);
            compressedString += counterString + str.charAt(i);
            counter = 1;
        }
        return compressedString;
    }


}
