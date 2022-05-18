package algorithms;

public class reqularExpression {

	public static void main(String[] args) {
		String a = "qqw";
		String id = "가나다화aA123-_.";
		String email = "abc@naver.com";
		String num = "080-335-0020";
		// \d : 숫자인 것 == [0-9]
		System.out.println(a.replaceAll("\\d", "바뀜")); // qqw
		
		// \D : 숫자가 아닌 것 == [^0-9]
		System.out.println(a.replaceAll("[^0-9]", "바뀜")); // 바뀜바뀜바뀜
		
		// [가-힣] : 한글인 것
		System.out.println(id.replaceAll("[가-힣]","0")); // 0000ㅁㅁ123-_.
		
		// [a-zA-Z] : 영문자
		System.out.println(id.replaceAll("[a-zA-Z]","0")); // 가나다화001234-_.
		
		// \\w : 대문자 소문자 언더바(_)
		System.out.println(id.replaceAll("\\w","0")); // 가다나화00000-0.
		
		// \\w+@\\w+\\.\\w+\\.\\w : 이메일
		System.out.println(email.replaceAll("\\w+@\\w+\\.\\w+(\\.\\w+)?","됨")); // 됨
		
		// \\d{2,3}-\\d{3,4}-\\d{4} : 전화번호
		System.out.println(num.replaceAll("\\d{2,3}-\\d{3,4}-\\d{4}","됨")); // 됨		
	}

}
