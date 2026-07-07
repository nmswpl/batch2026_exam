package in.co.nmsworks.exam;

public class ArmstrongNUmber {
    public static void main(String[] args) {
        ArmstrongNUmber armstrongNUmber = new ArmstrongNUmber();
        int generateCount =7;
        int i =11;
        while (generateCount!=0) {
            boolean isArmstrong = armstrongNUmber.isArmstrongNumber(i);

            if(isArmstrong){
                generateCount--;
                System.out.println(i);
                i++;
            }
            else{
                i++;
            }
        }
    }
    public boolean isArmstrongNumber(int num){


        int count = 0;
        int sum =0;

        int temp = num;
        while(num!=0){
            int digit = num%10;
            count++;
            num=num/10;
        }
        num=temp;

        while (num!=0){
            int digit = num%10;
            sum+=Math.pow(digit,count);
            num=num/10;
        }
        return sum == temp;
    }
}
