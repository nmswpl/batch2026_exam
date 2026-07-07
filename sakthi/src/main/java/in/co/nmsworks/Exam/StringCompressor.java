package in.co.nmsworks.Exam;

public class StringCompressor {


    public static void main(String[] args) {

        String input = "aaabbca";
        String output = compressString(input);

        System.out.println("Input:  " + input + " ");
        System.out.println("Output: " + output + " ");
    }

    private static String compressString(String input) {

        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;


        for (int i = 0; i < input.length(); i++) {

            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {

                compressed.append(count).append(input.charAt(i));
                count = 1;
            }
        }

        return compressed.toString();
    }

}