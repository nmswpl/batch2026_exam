package in.co.nmsworks.exam;

public class ArmstrongNumber {
    public static void main(String[] args) {
        ArmstrongNumber runner = new ArmstrongNumber();
        boolean isAmstrong = runner.isArmstrongNumber(153);
        if(isAmstrong){
            System.out.println("The number is armstrong number");
        }
        else{
            System.out.println("The number is not armstrong number");
        }
    }

    public boolean isArmstrongNumber(int num) {
        int temp = num;
        String numSize = num + "";
        int stringSize = numSize.length();
        int count = 0;
        while(temp<10){
            temp = temp / 10;
            count ++;
        }
        count++;
        int firstDigit = 0;
        int lastDigit = 0;
        int secondNum = 0;
        while(count > 0){
            firstDigit = num/100;
            lastDigit = num % 10;
            secondNum = (num/10) % 10;
            count--;
        }
        if(Math.pow(firstDigit,stringSize) + Math.pow(secondNum,stringSize) + Math.pow(lastDigit,stringSize) == num){
            return true;
        }
        return false;
    }
}
