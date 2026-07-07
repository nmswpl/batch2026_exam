package in.co.nmsworks.exam;

public class Problem {
    public static void main(String[] args) {
        Problem problem = new Problem();
        int count = 0;
        for(int i = 10; i < 10000; i++){
            if(problem.isArmstrongNumber(i)){
                System.out.println(i);
                count++;
                if(count == 7) break;
            }
        }

    }


    public boolean isArmstrongNumber(int num){
        int temp = num;
        int sum = 0;
        String length = ""+num;
        int power = length.length();

        while(temp > 0){
            int last = temp%10;
            //System.out.println(last);
            sum = sum + (int)Math.pow(last,power);

            temp  = temp/10;
        }

        //System.out.println(sum);

        return sum == num;
    }

}
