package in.co.nmsworks.exam;

public class CompressString {
    public static void main(String[] args) {

        CompressString runner = new CompressString();

        System.out.println(runner.compressString("aaabbca"));
    }

    private String compressString(String input){
        String answer = "";

        char letters[] = input.toCharArray();

        int count = 1;

        for(int i = 0; i < letters.length-1; i++){

            if(letters[i] != letters[i+1] && i <= letters.length -2){
                answer = answer + count + letters[i];
                count = 1;
            }
            else {
                count++;
            }
        }

        if(count >= 1){
            answer = answer + count + letters[letters.length-1];
        }

        return answer;
    }

}
