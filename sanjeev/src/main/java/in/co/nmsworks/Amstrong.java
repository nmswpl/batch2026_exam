package in.co.nmsworks;

public class Amstrong
{
    public static void main(String[] args) {
        Amstrong am = new Amstrong();
        int num = 10;
        int number =0;
        while(number<7){
            if (am.isAmsrtongNumber(num)) {
                System.out.println(num + " is a Amstrong NUmber");
                number++;
            }
            num++;
        }
    }
    public boolean isAmsrtongNumber(int num){
        int cube = 0;
        int org = num;
        int digitcount = String.valueOf(num).length();
        while (num>0){
            //System.out.println("gdf" + digitcount);
            int rem = num%10;
            cube = (int) (Math.pow(rem,digitcount) + cube);
            num=num/10;
        }
        return cube == org;
    }
}

