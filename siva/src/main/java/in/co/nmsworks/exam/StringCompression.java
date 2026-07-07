package in.co.nmsworks.exam;

public class StringCompression {
    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        stringCompression.run();
    }

    private void run() {
        String text = "aaabbca";
        System.out.println("Before Compression : "+text);
        String compressedText = compressString(text);
        System.out.println("After Compression : "+compressedText);
    }

    private String compressString(String text) {
        text += ' ';
        int count = 1;
        String compressedText = "";
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) != text.charAt(i+1)) {
                compressedText += (count+""+text.charAt(i));
                count = 1;
            }
            else
                count += 1;
        }
        return compressedText;
    }
}
