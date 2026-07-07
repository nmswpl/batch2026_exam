package in.co.nmsworks.exam;

public class CompressString {
    public static void main(String[] args) {
        String input = "aabbcca";
        String compressedOutput = compressString(input);
        System.out.println(compressedOutput);
    }

    private static String compressString(String input) {
        int i = 0;
        String compressed = "";
        while (i < input.length()) {
            char ch = input.charAt(i);
            int count = 1;

            while (i + 1 < input.length() && input.charAt(i + 1) == ch){
                i++;
                count++;
            }
            compressed += count + "" + ch;
            i++;
        }
        return compressed;
    }
}
