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

