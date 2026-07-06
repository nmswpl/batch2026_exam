package in.co.nmsworks;

public class StringCompressor
{
    public static void main(String[] args) {
        String input = "aaabbca";
        StringCompressor sc = new StringCompressor();
        System.out.println(sc.compressString(input));
    }
    private String compressString(String input) {
        StringBuffer sb = new StringBuffer();
        int count = 1;
        char[] ch = input.toCharArray();
        for (int i = 1; i < ch.length; i++) {
            if (ch[i] == ch[i - 1]) {
                count++;
            } else {
                sb.append(count).append(ch[i - 1]);
                count = 1;
            }
        }
        sb.append(count).append(input.charAt(input.length() - 1));
        return sb.toString();
    }

        /*
        int index =0;
        while(index<input.length()){
            int count = 1;
            //System.out.println("1");
            while(input.charAt(index) == input.charAt(index+1)){
                System.out.println("2");
                count++;
                index++;
            }
            sb.append(count);
            sb.append(input.charAt(index));
        }
        System.out.println(sb);
        return sb.toString();

         */

}
