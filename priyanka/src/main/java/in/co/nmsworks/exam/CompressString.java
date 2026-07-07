package in.co.nmsworks.exam;

public class CompressString {
    public static void main(String[] args) {
        CompressString compress = new CompressString();
        String result = compress.compressString("aaabbcca");
        System.out.println(result);
    }
    private String compressString(String input){
        StringBuilder builder  = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int j =0;
            int count = 1;
            while (input.charAt(j)==input.charAt(j+1)){
                count += 1;
                j++;
            }
            builder.append(input.charAt(i)+count);
            count=0;

        }
        return new String(builder.toString());
    }
}
