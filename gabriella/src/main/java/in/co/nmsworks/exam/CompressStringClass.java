package in.co.nmsworks.exam;

public class CompressStringClass {
    public static void main(String[] args) {
        CompressStringClass compressStringClass = new CompressStringClass();
        String str = "aaabbca";
        String compressedString = compressStringClass.compressString(str);
        System.out.println(compressedString);
    }

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
