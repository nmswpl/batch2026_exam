package in.co.nmsworks.Exam;

public class ArmstrongNumber {

    public static void main(String[] args) {
        ArmstrongNumber number = new ArmstrongNumber();
        System.out.println("The first 7 Armstrong numbers greater than 10 are:");

        int count = 0;
        int currentNum = 11;

        while (count < 7) {
            if (number.validArmstrongNumber(currentNum)) {
                System.out.println(currentNum);
                count++;
            }
            currentNum++;
        }
    }

    private boolean validArmstrongNumber(int number) {
        if (number < 0) {
            return false;
        }
        int originalNumber = number;


        int digitCount = 0;
        int temp = number;
        while (temp > 0) {
            digitCount++;
            temp /= 10;
        }


        int sum = 0;
        temp = number;
        while (temp > 0) {
            int remainder = temp % 10;
            sum += Math.pow(remainder, digitCount);
            temp /= 10;
        }

        return sum == originalNumber;
    }
}