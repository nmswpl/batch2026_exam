package in.co.nmsworks.exam;

import static java.lang.Math.pow;

public class ArmstrongNumber {

    public static void main(String[] args) {
        ArmstrongNumber arms = new ArmstrongNumber();
        boolean output = arms.isArmstrongNumber(123);
        System.out.println("Armstrong Number :"+output);
    }

    public boolean isArmstrongNumber(int num){
        int sum =0;
        int temp = num;
        boolean answer;
        while(num>0){
            int lastDigit = temp % 10;
            sum+=Math.pow(lastDigit,3);
            temp = temp/10;
        }
        if(sum==num){
            System.out.println("Armstrong Number");
            answer = true;
        }
        else{
            System.out.println("Not a Armstrong Number");
            answer = false;
        }
        return answer;
    }
}
