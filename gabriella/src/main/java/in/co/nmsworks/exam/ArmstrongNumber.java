package in.co.nmsworks.exam;

public class ArmstrongNumber {
    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        for (int i = 10; i < 10000; i++){
            if (armstrongNumber.isArmstrongNumber(i)) {
                System.out.println(i);
            }
        }
    }

    private boolean isArmstrongNumber(int num) {
        int sumOfDigits = 0;
        String number = String.valueOf(num);
        int numLength = number.length();
        int tmp = num;

        while (tmp != 0){
            int rem = tmp % 10;
            tmp = tmp / 10;
            int value = (int) Math.pow(rem, numLength);
            sumOfDigits += value;
        }
        if (num == sumOfDigits) return true;
        else return false;

    }
}
