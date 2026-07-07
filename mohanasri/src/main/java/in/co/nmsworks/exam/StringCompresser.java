package in.co.nmsworks.exam;

public class StringCompresser {
    public static void main(String[] args) {
        StringCompresser strComp = new StringCompresser();
        String compressedString = strComp.compressString("aaabbbccdd");
        System.out.println("Compressed string is : " + compressedString);
    }

    private String compressString(String word) {

        String str = "";
        int length = word.length();
        int count = 1;
        for (int i = 0; i < length; i++) {
            if (i + 1 < length && word.charAt(i) == word.charAt(i + 1)) {
                count++;
            } else {
                str =  str+count+word.charAt(i);
                count = 1;
            }
        }
        return str;
    }

}


