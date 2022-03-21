/*
stream api의 3단계 : 생성/가공/결과
   생성 : stream()
   가공 : filter(),map(),sorted()
   결과 : count(),foreach()

일급 객체 : 변수처럼 사용가능하며 매개변수로 전달가능

Stream은 함수형 인터페이스를 받게 되어있고
람다식은 함수형 인터페이스를 반환하고 또한 1급객체이므로
Stream API의 매개변수로 전달이 가능하다

@FunctionalInterface을 붙인 추상인터페이스로 함수형인터페이스 생성가능
1개의 함수만 갖을 수 있다

Java에서 제공하는 함수형 인터페이스
Supplier<T>
Consumer<T>
Function<T, R>
Predicate<T>

일반 메소드 참조 ==> 클래스명::메소드
*/
/*중간연산*/
   //filter
   Stream<String> stream = list.stream() .filter(name -> name.contains("a"));
   //map
   Stream<String> stream = names.stream() .map(s -> s.toUpperCase());
   //sorted
   Stream<String> stream = list.stream() .sorted(Comparator.reverseOrder());
   //distinct (equals와 hashcode를 오버라이드해야 기능이 동작함)
   Stream<String> stream = list.stream() .distinct();
   //peek ( stream에 영향을 주지 않고 확인(peek)해보는 용도)/ peek 파라미터 : 함수형 인터페이스 Consumer
   int sum = IntStream.of(1, 3, 5, 7, 9) .peek(System.out::println) .sum();
   //형변환
   Stream.of(1.0, 2.0, 3.0) .mapToInt(Double::intValue) .mapToObj(i -> "a" + i)
      
/*최종연산*/
   max/min/sum/average/count
   
   collect
