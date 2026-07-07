package in.co.nmsworks.exam;

public class MainUser {
    public static void main(String[] args) {
        UserPassword userPassword=new UserPassword();


        userPassword.readDb();
        System.out.println("Test case for valid");
       userPassword.check("felsya","bS2`N4CtBB");
        System.out.println();
        System.out.println("Test case for invalid password");
        userPassword.check("felsya","bS2`N4CtB");
        System.out.println();
        System.out.println("Test case for Invalid uername");
        userPassword.check("felya","bS2`N4CtBB");




    }
}
