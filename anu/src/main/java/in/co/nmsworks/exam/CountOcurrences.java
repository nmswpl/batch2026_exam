package in.co.nmsworks.exam;

public class CountOcurrences {
    private String compressString(String input) {
        String result = "";
        int count = 0;
        char ch = input.charAt(0);

        for (int i = 0; i < input.length(); i++) {
            char line = input.charAt(i);
            if (line == ch) {
                count++;
            } else {
                result += "" + ch + count;
                ch = line;
                count = 1;
            }
        }
        result += "" + ch + count;
        return result;
    }

    public static void main(String[] args) {
        CountOcurrences countOcurrences = new CountOcurrences();
        System.out.println(countOcurrences.compressString("aaabbca"));
    }
}


