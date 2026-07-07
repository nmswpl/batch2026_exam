package in.co.nmsworks.exam;

public class ArmstrongNumber {
    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        for (int i = 10; i < 1000; i++){
            if (armstrongNumber.checkArmstrongNumber(i)) {
                System.out.println(i);
            }
        }
    }

    private boolean checkArmstrongNumber(int num) {
        int sumOfDigits = 0;
        String number = String.valueOf(num);
        int numLength = number.length();
        int tmp = num;

        while (tmp != 0){
            tmp = tmp / 10;
            int rem = tmp % 10;
            int value = 1;
            for (int i = 0; i < numLength; i++){
                value *= rem;
            }
            sumOfDigits += value;

        }
        if (num == sumOfDigits) return true;
        else return false;

    }
}
