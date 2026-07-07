package in.co.nmsworks.exam;

public class ArmstrongNumber {
    public static void main(String[] args) {
        ArmstrongNumber.checkNumber(153);
    }

    private static void checkNumber(int number) {
        int original = number;
        int temp = number ;
        int countDigit = 0;
        while (temp > 0){
            int digit = temp % 10;
            countDigit ++;
            temp /= 10;
        }
        temp = number;
        int sum = 0;
        while (temp > 0){
            int digits = temp % 10;
            sum += Math.pow(digits,countDigit);
            temp /= 10;
        }
        if (sum == original){
            System.out.println(" Given number "+original+" is Armstrong number ");

        }else {
            System.out.println("Given number is not armstrong");
        }


    }


}
