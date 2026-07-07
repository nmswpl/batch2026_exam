package in.co.nmsworks.exam;

public class ArmstrongNumber {
    public static void main(String[] args) {
        ArmstrongNumber armstrongNumber = new ArmstrongNumber();
        int count = 0;

        for (int i = 10; i <= 10000; i++) {


            if (count != 7) {


                boolean ans = armstrongNumber.isArmstrongNumber(i);

                if (ans) {
                    System.out.println(i);
                    count++;

                }
            }
        }
    }


    public boolean isArmstrongNumber(int num) {
        int cnt = 0;
        int res = 0;
        int number = num;
        int ans = num;
        while (num > 0) {

            num /= 10;
            cnt++;

        }
        int pow = 0;

        while (ans > 0) {
            res = ans % 10;
            pow += Math.pow(res, cnt);
            ans /= 10;
        }

        if (pow == number) {
            return true;
        } else {
            return false;
        }


    }
}
