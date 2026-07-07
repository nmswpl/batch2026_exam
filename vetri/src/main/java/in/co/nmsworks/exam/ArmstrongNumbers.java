package in.co.nmsworks.exam;

public class ArmstrongNumbers {

    public static void main(String[] args) {

        int count = 0;
        int currentNum = 123;

        System.out.println("The first 7 Armstrong numbers greater than 10 are:");

        while (count < 7) {
            if (isArmstrongNumber(currentNum)) {
                System.out.println(currentNum);
                count++;
            }
            currentNum++;
        }

    }





    public static boolean isArmstrongNumber(int num) {
        if(num<0){
            return false;
        }

        int originalNum = num;
        int temp = num;
        int digits = 0;
        int sum = 0;

        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        temp = num;
        while (temp > 0) {
            int remainder = temp % 10;
            sum += Math.pow(remainder, digits);
            temp /= 10;
        }


        return sum == originalNum;
    }

}
