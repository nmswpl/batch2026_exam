package in.co.nmsworks.exam;

public class RunnerAmstrong {
    public static void main(String[] args) {
        AmstrongNumber amstrongNumber = new AmstrongNumber();
        int number = 123;
        int found=0;
        while (found < 7) {
            if (amstrongNumber.isArmstrongNumber(number)) {
                System.out.println(number);
                found++;
            }
            number++;
        }
        System.out.println();
    }
}
