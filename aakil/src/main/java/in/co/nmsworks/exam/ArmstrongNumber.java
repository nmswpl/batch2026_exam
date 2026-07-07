package in.co.nmsworks.exam;

public class ArmstrongNumber {
    public static void main(String[] args) {
        checkArmstrongNumber(123);
    }

    private static void checkArmstrongNumber(int num) {
        int temp = num;
        int count = 0;
        while (temp != 0){
            temp /= 10;
            count++;
        }

        temp = num;
        int res = 0;
        while (temp != 0){
            int rem = temp % 10;
            res += (int) Math.pow(rem, count);
            temp /= 10;
        }

        if (num == res){
            System.out.println(num + " is an Armstrong Number");
        } else {
            System.out.println(num + " is not an Armstrong Number");
        }
    }
}
