package in.co.nmsworks.exam;

public class ArmStrongNumber {
    public static void main(String[] args) {
        ArmStrongNumber armStrongNumber = new ArmStrongNumber();
        int count = 0;
        int number = 10;
        System.out.println(armStrongNumber.isArmStrongNumber(153));
//        while (count < 8) {
//            if (armStrongNumber.isArmStrongNumber(number)) {
//                System.out.println(number);
//                number ++;
//                count ++;
//            }
//        }

    }

    private boolean isArmStrongNumber(int number) {
        int noOfDigits = 0;
        int tempNum = number;
        while (number > 0) {
            tempNum = number / 10;
            noOfDigits++;

        }
        int total = 0;
        while (number > 0) {
            int remainder = number % 10;
            double power = Math.pow(remainder,noOfDigits);
            total += (int) power;
            tempNum = number / 10;
        }
        if (total == number) {
            System.out.println(number+" is a amrstrong");
            return true;
        }
        return false;
    }
}
