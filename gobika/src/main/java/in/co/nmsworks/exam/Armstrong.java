package in.co.nmsworks.exam;

public class Armstrong {
    public static void main(String[] args) {
        Armstrong armstrong = new Armstrong();
        boolean isArmStrong = false;
        for (int i = 10; i < 10000; i++) {
            isArmStrong = armstrong.findArmstrong(i);
            if (isArmStrong){
                System.out.println(i + " is Armstrong number");
            }

        }
        armstrong.findArmstrong(153);
    }

    private boolean findArmstrong(int num) {
        boolean isArmstrong = false;
        int numLength = String.valueOf(num).length();
        int armStrongNum = num;
        int sum = 0;
        while (num > 0){
            int digit = num % 10;
            sum += (int) Math.pow(digit,numLength);
            num = num / 10;
        }
        if (sum == armStrongNum){
            isArmstrong = true;
        }
        else {
           isArmstrong = false;
        }
        return isArmstrong;
    }
}
