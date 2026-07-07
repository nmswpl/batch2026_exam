package in.co.nmsworks.exam;

import java.util.Scanner;

public class ArmStrongNumber {
    public static void main(String[] args) {
        ArmStrongNumber armStrongNumber = new ArmStrongNumber();
       for (int i = 10; i < 10000 ; i++) {
           boolean trueOrFalse = armStrongNumber.isArmstrongNumber(i);

          if (trueOrFalse == true) {
               System.out.println( i + " is an Armstrong number");
          }
        }

    }

    private boolean isArmstrongNumber(int num) {
        String number = String.valueOf(num);
        int value = num;
        double digit ;
        double sum = 0;
            while ( num > 0) {
                digit = num % 10;
                num = num /10;
                double power = Math.pow(digit, number.length());
                sum += power;
            }

            if (sum ==  value){
                return true;
            }
            else {
                return false;
            }
    }
}
