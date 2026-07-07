package in.co.nmsworks.exam;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber=new ArmstrongNumber();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Give number to check isArmstrong");
        int num=scanner.nextInt();
        if(armstrongNumber.isArmstrongNumber(num))
        {
            System.out.println(num+" is an Armstrong number");
        }
        else {
            System.out.println(num+" is not Armstrong number");
        }
        scanner.close();
    }

    public boolean isArmstrongNumber(int number) {
        int sum=0;
        int initial =number;
        while(number>0)
        {
            int digit=number%10;
            number=number/10;
            sum+=(digit*digit*digit);
        }
        return sum == initial;
    }
}
