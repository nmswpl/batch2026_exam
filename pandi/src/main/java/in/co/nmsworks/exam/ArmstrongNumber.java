package in.co.nmsworks.exam;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber=new ArmstrongNumber();
        int count=7;
        System.out.println("First 7 Armstrong Numbers :");
        while(count>0)
        {
            for(int i=10;i<Integer.MAX_VALUE-1;i++)
            {
                if(armstrongNumber.isArmstrongNumber(i))
                {
                    System.out.print(i+" ");
                    count--;
                }
            }

        }

    }

    public boolean isArmstrongNumber(int number) {
        int sum=0;
        int initial =number;
        int num=number;
        int digitCount=0;
//        while()
        while(initial>0)
        {
            initial=initial/10;
            digitCount++;
        }
        while(num>0)
        {
            int digit=num%10;
            num=num/10;
            sum+= (int) Math.pow(digit,digitCount);
        }
        return sum == number;
    }
}
