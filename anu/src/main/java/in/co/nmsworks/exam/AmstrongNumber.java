package in.co.nmsworks.exam;

public class AmstrongNumber {
    public boolean isArmstrongNumber(int num) {
        int temp = num;
        int count = 0;
        int sum = 0;

        while(temp != 0){
            temp=temp/10;
            count++;
        }
        System.out.println("digit count : " + count);
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, count);
            num = num / 10;
        }
        if (sum == temp) {
            return true;
        } else {
            return false;
        }
    }
}

