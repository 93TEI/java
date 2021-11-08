import java.util.*;
public class 정렬 {

	public static void main(String[] args) {
		int[] arr = {4,23,33,15,17,19};
		Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new); // 스트림 int -> integer (내림차순하기위해)
		int[] arr3 = Arrays.stream(arr2).mapToInt(Integer::intValue).toArray(); // 스트림 integer -> int
		
		Arrays.sort(arr3); // 오름차순
		Arrays.sort(arr2, Collections.reverseOrder()); // 내림차순
		
		for(Integer temp : arr2)
			System.out.println(temp);
	}

}
