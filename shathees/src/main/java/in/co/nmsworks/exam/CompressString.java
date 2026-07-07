package in.co.nmsworks.exam;

public class CompressString {
    public static void main(String[] args) {
        CompressString co = new CompressString();
        String input = "aaabbcaa";
        String output = co.compressString(input);
        System.out.println(output);

    }
    private String compressString(String input){
        StringBuilder sb = new StringBuilder();
        char prev = input.charAt(0);
        int count = 1;
        for (int k = 1 ;k < input.length() ; k++){
            char cur = input.charAt(k);
            if (prev == cur){
                count++;

            }else{
                sb.append(count);
                sb.append(prev);
                prev = cur;
                count = 1;

            }

        }
        if (count >= 1){
            sb.append(count);
            sb.append(prev);
        }
        return sb.toString();


    }
}
