package in.co.nmsworks.exam.question1;

import java.util.ArrayList;
import java.util.*;

public class ArmstrongNumber {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        ArmstrongNumber armstrong = new ArmstrongNumber();
        int counter = 10;

        while (true) {

            int armstrogNumber = armstrong.checkArmstrongNumber(counter);
            list.add(armstrogNumber);
            int size = list.size();
            if(list.get(size - 1) == 0)
            {
                list.remove(size - 1);
            }
            if (list.size() >= 7) break;

            counter++;
        }

        System.out.println("Armstrong numbers are: ");
        for (Integer i : list) {

            System.out.println(i+" ");
        }
    }

    private int checkArmstrongNumber(int number) {


        String numberString = number+"";
        int size = numberString.length();
        int sum = 0;
        int testNumber = number;

        while (testNumber != 0)
        {
            int quotient = testNumber%10;
            testNumber /= 10;
            sum += Math.pow(quotient,size);
        }

        if (sum == number)
        {
            return number;
        }
        else
        {
            return 0;
        }
    }
}
