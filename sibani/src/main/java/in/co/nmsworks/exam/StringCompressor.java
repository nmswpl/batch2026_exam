package in.co.nmsworks.exam;

public class StringCompressor {
    public static void main(String[] args) {
        StringCompressor stringCompressor = new StringCompressor();
        stringCompressor.compressString("aaabbca");
    }

    private void compressString(String input) {
        char[] charArray = input.toCharArray();
        int aCount = 1;
        int bCount = 1;
        int cCount = 1;
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'a') {
                if (charArray[i] == charArray[i + 1]) {
                    aCount++ ;
                    if (charArray[i + 1] == charArray[i + 2])
                        aCount++;
                        break;
                }
            }
        }
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'b') {
                if (charArray[i] == charArray[i + 1]) {
                    bCount++;
                    break;
                }
            }
        }
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == 'c') {
                if (charArray[i] == charArray[i + 1]) {
                    cCount++;
                    break;
                }
            }
        }
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == 'a') {
                if (charArray[i] == charArray[i + 1]) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(aCount+"a"+bCount+"b"+cCount+"c"+count+"a");
    }
}
