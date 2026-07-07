package in.co.nmsworks.exam;

public class ArmstrongNumbers {

    public static void main(String[] args) {

        int counter = 0;
        int currentNumber = 123;

        System.out.println("The first 7 Armstrong numbers greater than 10 are:");
        while (counter < 7) {
            if (isArmstrongNumber(currentNumber)) {
                System.out.println(currentNumber);
                counter++;
            }
            currentNumber++;
        }

    }
    public static boolean isArmstrongNumber(int num) {
        if(num<0){
            return false;
        }

        int originalNumber = num;
        int temporary = num;
        int digits = 0;
        int sum = 0;

        while (temporary > 0) {
            digits++;
            temporary /= 10;
        }

        temporary = num;
        while (temporary > 0) {
            int remainder = temporary % 10;
            sum += Math.pow(remainder, digits);
            temporary /= 10;
        }

        return sum == originalNumber;
    }

}
