package in.co.nmsworks.sample.exam;

public class AmstrongNoCalculator {

    public static void main(String[] args) {
        AmstrongNoCalculator calculatorObj = new AmstrongNoCalculator();

        calculatorObj.checkAmstrongNo(153);
    }

    private void checkAmstrongNo(int number) {
        int originalNumber = number;
        String numberStr = String.valueOf(number);
        int noOfDigits = 0 ;
        while(number > 0 ){
            int quotient = number/10;
            number = quotient ;
            noOfDigits++;
        }

        int sum = 0 ;
        for (int i = 0; i < numberStr.length(); i++) {
            int value = numberStr.charAt(i) - 48;
            sum += Math.pow((double)value, (double)noOfDigits);
        }

        if(sum != originalNumber){
            System.out.println(originalNumber+" is not an amstrong no");
        }
        else{
            System.out.println(originalNumber+" is an amstrong no");
        }
//        System.out.println("sum : " + sum);
//        System.out.println("No of digits : " + noOfDigits);
    }
}
