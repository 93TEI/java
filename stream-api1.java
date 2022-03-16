// stream api를 사용하면 더 추상적이며(형태에 따라 바뀌지 않고 어떤 데이터가 와도 똑같은 코드로 처리 가능)
// 클린코드가 가능하다. ( 클린코드는 대입문이 없는 프로그래밍 )
// 가독성이 좋음


    String[] nameArr = {"하나","둘","셋","네에엣"};
		List<String> nameList = Arrays.asList(nameArr);

		// 원본의 데이터가 아닌 별도의 Stream을 생성 -> 무결성
		Stream<String> nameStream = nameList.stream(); // stream 임포트해야함
		Stream<String> arrayStream = Arrays.stream(nameArr);

		// 복사된 데이터를 정렬하여 출력함
		nameStream.sorted().forEach(System.out::println);
		arrayStream.sorted().forEach(System.out::println);
