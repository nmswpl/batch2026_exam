package in.co.nmsworks.exam;

public class ArmstrongNumber {
    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        armstrongNumber.run();
    }

    private void run() {
        int neededCount = 7;
        int number = 11;
        System.out.println("First 7 Armstrong numbers greater than 10");
        while (neededCount != 0) {
            if (isArmstrongNumber(number)) {
                System.out.println(number);
                neededCount -= 1;
            }
            number += 1;
        }
    }

    private boolean isArmstrongNumber(int number) {
        int temp = number;
        long digitCount = getNumberOfDigits(number);
        long sum = 0;
        while (temp != 0) {
            sum += Math.pow(temp%10, digitCount);
            temp /= 10;
        }
        if (sum == number)
            return true;
        return false;
    }

    private long getNumberOfDigits(int number) {
        long digitCount = 0;
        while (number != 0) {
            digitCount += 1;
            number /= 10;
        }
        return digitCount;
    }
}
