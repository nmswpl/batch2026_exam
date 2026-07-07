package in.co.nmsworks.exam.question1;

public class ArmstrongNumber {

    public static void main(String[] args) {

        int number = 123;
        ArmstrongNumber armstrong = new ArmstrongNumber();
        armstrong.checkArmstrongNumber(number);
    }

    private void checkArmstrongNumber(int number) {

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
            System.out.println("The given number "+number+" is an Armstrong number.");
        }
        else
        {
            System.out.println("The given number is not an armstrong number.");
        }
    }
}
