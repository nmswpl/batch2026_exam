package in.co.nmsworks.exam;

public class ArmstrongNumber {
    public static void main(String[] args) {
        ArmstrongNumber amsNo = new ArmstrongNumber();
        int count = 0;
        int currentNum = 11;
        System.out.println("First 7 Armstrong numbers greater than 10:");

        while (count < 7) {
            if (amsNo.isArmstrongNumber(currentNum)) {
                System.out.println(currentNum);
                count++;
            }
            currentNum++;
        }
    }

    public boolean isArmstrongNumber(int num) {
        int originalNum = num;
        int sum = 0;
        int power = String.valueOf(num).length();
        while (num != 0) {
            int rem = num % 10;
            sum += Math.pow(rem, power);
            num = num / 10;
        }

        return sum == originalNum;
    }
}

