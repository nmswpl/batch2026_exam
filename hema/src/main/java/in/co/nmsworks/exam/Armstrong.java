package in.co.nmsworks.exam;

public class Armstrong {
    public static void main(String[] args) {
        Armstrong armstrong = new Armstrong();
        int count = 0;
        int i = 1;
        while (count < 7)
        {
            boolean result = armstrong.isArmstrongNumber(i++);
            if(result == true)
            {
                count++;
                System.out.println("Armstrong number "+ count+" = "+ (i-1));
            }
        }
//        boolean result = armstrong.isArmstrongNumber(153);
//        System.out.println(result);
    }

    private boolean isArmstrongNumber(int number) {

        int temp = number;
        int sum = 0;
        while (temp!=0)
        {
            int lastDigit = temp%10;
            sum = sum + (lastDigit * lastDigit *lastDigit);
            temp = temp / 10;

        }

        if( sum == number)
            return true;
        return false;
    }

}
