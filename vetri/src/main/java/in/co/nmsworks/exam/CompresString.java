package in.co.nmsworks.exam;

public class CompresString {
    public static void main(String[] args) {
        CompresString sr = new CompresString();
        System.out.println(sr.compressString("abbcc"));
    }

    private String compressString(String input) {
        if (input == null) {
            return null;
        }
        if (input.isEmpty()) {
            return "";
        }

        String compressed = "";
        int count = 1;

        for (int i = 0; i < input.length(); i++) {

            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                compressed += input.charAt(i) + "" + count;
                count = 1;
            }
        }

        return compressed;
    }
}
