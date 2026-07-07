package in.co.nmsworks.exam;

import java.util.ArrayList;
import java.util.List;

public class ArmstrongNumber {
    public static void main(String[] args) {

        findSevenArmstrongNumberGreaterThanN(7);
    }

    public static void findSevenArmstrongNumberGreaterThanN(int n) {

        List<Integer> armstrongNumbers = new ArrayList<>();

        int num = 11;
        while (armstrongNumbers.size() < n) {
            if (isArmstrongNumber(num)) {
                armstrongNumbers.add(num);
            }
            num++;
        }

        System.out.println("Armstrong numbers greater than " + 10 + " are : ");
        for (Integer armstrongNumber : armstrongNumbers) {
            System.out.println(armstrongNumber);
        }
    }

    public static boolean isArmstrongNumber(int num) {

        int originalNum = num;
        int result = 0;

        int length = lengthOfNum(num);

        while (num > 0) {
            int rem = num % 10;
            num = num/10;
            System.out.println(num);
            System.out.println("rem -" + rem);

            result += (int) Math.pow(rem, length);
        }

        System.out.println("original : " + originalNum);
        System.out.println("result : " + result);
        return originalNum == result;
    }

    private static int lengthOfNum(int num) {
        int length = 0;

        while (num > 0) {
            length++;
            num = num/10;
        }

        return length;
    }
}
