package in.co.nmsworks.exam;

public class Armstrong {
    public static void main(String[] args) {
        Armstrong armstrong = new Armstrong();
        int count = 0;
        int i = 10;
        while (count < 7)
        {
            boolean result = armstrong.isArmstrongNumber(i++);
            if(result)
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
            int length = String.valueOf(number).length();
            int lastDigit = temp % 10;
            sum = sum + (int) Math.pow(lastDigit,length);
            temp = temp / 10;

        }

        if( sum == number)
            return true;
        return false;
    }

    private String compressString(String input)
    {
        String[] array = input.split("");

        for (String s : array) {



        }


        return null;
    }

}
