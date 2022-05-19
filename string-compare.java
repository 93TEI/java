    //string, stringbuffer, stringbuilder 비교
    public static void howAboutString(){
        String str = "garbage";
        str = "new!"; // str이 새로운 문자열을 가리키고, 원래 문자열은 GC가 처리해줄 때까지 힙메모리 잡아둠.
                        // 변하지 않는 문자열을 자주 읽을 때 사용하면 성능 좋음

        StringBuffer sb = new StringBuffer();
        sb.append(str); // StringBuffer는 추가,삭제 등을 동일 객체 내에서 처리 가능하여 문자열을 빈번하게 바꿀 때 성능 좋음
                        // 동기화 지원 -> 멀티쓰레드 환경에서 안정성을 갖고있음

        StringBuilder sd = new StringBuilder(); // StringBuilder는 문자열을 빈번하게 바꿀 때 성능 똑같이 좋지만
                                                // 멀티쓰레드는 지원안됨. 대신 단일쓰레드에서 성능이 더 좋음
        sd.append(str);


        System.out.println(str+sb+sd);
    }
