import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        List<String> mylist = Arrays.asList("a","b","cc","ddd");
        mylist.stream().filter(x->x.length()>1).map(x->x.toUpperCase()).forEach(x->System.out.println(x));

        System.out.println(mylist); // 원본은 손상되지 않음. stream은 따로 만들어져 처리되기 때문
        String n1 = new String("h");
        String n2 = new String("h");

        System.out.println("h" == "h"); // true
        System.out.println(n1.equals(n2)); // true
        System.out.println(n1 == n2); // false
    }
}
