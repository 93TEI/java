import java.util.*;
import java.util.stream.*;

class Student{
    private String name;
    private int age;
    Student(String n, int a){
        this.name = n;
        this.age = a;
    }
    public String getName() {
        return name;
    }
    public int getAge(){
        return age;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        //stream 사용
        List<String> mylist = Arrays.asList("a","b","cc","ddd","ddd");
        mylist.stream().filter(x->x.length()>1).map(x->x.toUpperCase()).forEach(x->System.out.println(x));

        System.out.println(mylist); // 원본은 손상되지 않음. stream은 따로 만들어져 처리되기 때문
        String n1 = new String("h");
        String n2 = new String("h");

        //equal과 hashcode
        System.out.println("h" == "h"); // true
        System.out.println(n1.equals(n2)); // true // equals : 내용이 같은지 , hashcode : 객체가 같은지
        System.out.println(n1 == n2); // false

        //distinct()
        mylist.stream().distinct().forEach(x->System.out.println(x)); //distinct가 equals,hashcode 오버라이드 안해도 작동

        Stream<String> st = mylist.stream();
        st.forEach(x->System.out.println(x));

        System.out.println("===================");
        System.out.println("tabout test");

        //max(), getAsInt()
        List<Integer> myintlst = Arrays.asList(10,20,30,40,50);
        System.out.println(myintlst.stream().mapToInt(x->x).max().getAsInt()); // map(Integer::intValue)가 아니라 mapToInt()를 써야함, getAsInt안하면 오브젝트로 나옴
        
        //class 생성 및 사용
        Student s = new Student("tei", 10);
        System.out.println(s.getName() + "," + s.getAge());

        //원시타입stream, 특정필드최대값, peek()
        List<Student> stdlist = IntStream.range(1,10).mapToObj(x-> new Student("name" + x, x)).peek(x->System.out.println(x)).collect(Collectors.toList());
        System.out.println(stdlist.stream().map(x->x.getAge()).mapToInt(x->x).max().getAsInt()); //9

        // 람다식 , mapToInt에서 바로 길이 반환
        mylist.stream().mapToInt(String::length).forEach(x-> System.out.println(x));

        //error
        st.collect(Collectors.averagingInt(Student::getAge));
    }
}
