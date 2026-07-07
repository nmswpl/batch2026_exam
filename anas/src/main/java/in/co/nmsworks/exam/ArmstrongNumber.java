package in.co.nmsworks.exam;

import java.util.ArrayList;
import java.util.List;

public class ArmstrongNumber {
    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();

        int number = 11;

        int noOfArmstrongNumbers = 0;
        List<Integer> armsNumberList = new ArrayList<>();

        while (noOfArmstrongNumbers < 7) {

            if (armstrongNumber.isArmstrongNumber(number)) {
                System.out.println(number);
                noOfArmstrongNumbers ++;
                number ++;
            }
            else {
                number ++;
            }

        }
    }

    private boolean isArmstrongNumber(int number) {

        int digitCount = 0;
        int sum = 0;
        int a = number;
        int b = number;

        while (a > 0){
            a = a / 10;
            digitCount ++;
        }
        while (b > 0){
            int digit = b % 10;
            sum += digit ^ digitCount;
            b = b / 10;

        }
        if ( sum == number){
            return true;
        }
        else{
            return false;
        }
    }

}

