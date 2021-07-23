package Collection;

import java.util.*;

public class HomeWork {

    public static void main(String[] args) {

        Map<String, Integer> hm = new HashMap<>();


        String[] words = {"house", "victory", "fish", "dog", "dog", "cat", "home", "door", "home", "dog", "cat"};


        //Word Counter
        for (String s :
                words) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        System.out.println(hm);
        System.out.println(" ");


        //Unique words
        Set<String> unique = new HashSet<>(Arrays.asList(words));
        System.out.println(unique);
        System.out.println("");

        //Phone Book with finder
        PhoneBook pb = new PhoneBook();

        pb.add("Alex", "123");
        pb.add("Sergey", "456");
        pb.add("Marina", "789");
        pb.add("Marina", "581");

        //Enter Name
        String find = "Marina";

        Set<String> s = pb.get(find);
        System.out.println(find + s);

    }

}

