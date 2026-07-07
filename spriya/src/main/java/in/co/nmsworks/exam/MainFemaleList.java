package in.co.nmsworks.exam;

import java.util.Set;

public class MainFemaleList {

    public static void main(String[] args) {
        FemaleList main=new FemaleList();
        main.readDbForActiveList();

        Set<String> nameList=main.getActiveFemaleName();

        for (String s : nameList) {
            System.out.println(s);

        }
    }
}
