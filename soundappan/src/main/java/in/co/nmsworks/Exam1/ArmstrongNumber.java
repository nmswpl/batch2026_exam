package in.co.nmsworks.Exam1;

public class ArmstrongNumber {
    public static boolean isArmstrongNumber(int num) {
        int count = 0;
        int value = num;
        int number = num;
        while (value != 0) {
            value /= 10;
            count++;
        }
        int sum = 0;
        while (number != 0) {
            int digits = number % 10;
            sum += (int) Math.pow(digits, count);
            number = number / 10;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrongNumber(53));
    }
}
