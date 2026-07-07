package in.co.nmsworks.exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private Set<String> getActiveFemaleName(List<UserDetails> users) {
        Set<String> activeFemale = new HashSet<>();

        for (UserDetails u : users) {
            if(u.isActive()){
                if ("Female".equalsIgnoreCase(u.getGender())) {
                    activeFemale.add(u.getName());
                }
            }
        }

        return activeFemale;
    }

    public static void main(String[] args) {
        UserDetails userOne = new UserDetails("anushri","female" ,true);
        UserDetails userTwo = new UserDetails("Vijiayashree","female" ,false);
        UserDetails userThree = new UserDetails("Vijay","male" ,false);
        UserDetails userFour = new UserDetails("virat","male" ,true);
        UserDetails userFive = new UserDetails("archana","Female" ,true);

        List<UserDetails> users = new ArrayList<>();
        users.add(userOne);
        users.add(userTwo);
        users.add(userThree);
        users.add(userFour);
        users.add(userFive);

        User usr = new User();
        Set<String> detailOfUser = usr.getActiveFemaleName(users);
        System.out.println(detailOfUser);
    }
}

