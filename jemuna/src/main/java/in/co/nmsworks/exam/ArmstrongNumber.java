package in.co.nmsworks.exam;

public class ArmstrongNumber {

    public static void main(String[] args) {
        ArmstrongNumber arms = new ArmstrongNumber();
        arms.isArmstrongNumber(123);
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
