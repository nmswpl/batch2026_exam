package in.co.nmsworks.exam;

public class CompressString {
    public static void main(String[] args) {
        CompressString runnerObj = new CompressString();
        String compressed = runnerObj.compressString("aaabbcca");
        System.out.println("The compressed string is :: " + compressed);
    }

    private String compressString(String input) {
        char[] array = input.toCharArray();
        String result = "";
        int count = 1;
        for (int i = 0; i < array.length -1; i++) {
            if (array[i] == array[i + 1]) {
                count++;
            } else {
                result = result +  count + array[i] ;
                count = 1;
            }
        }
        return result;
    }
}