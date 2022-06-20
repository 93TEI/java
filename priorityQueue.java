import java.util.Comparator;
import java.util.PriorityQueue;

public class pq {
    public static void main(String[] args){
        PriorityQueue pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);


        /*
         * 우선순위 큐는 오름차순 default
         * 그리고 큐에서 뽑아낼 때(peek, poll) -> 우선순위가 높은 것을 뽑음
         * 우선순위는 숫자가 낮을수록 높은 것이기 때문에 낮은 숫자가 먼저 나온다.
         * 높은 숫자가 먼저 나오게 하려면 우선순위 큐를 선언할 때 compare메소드를 override하여
         * 정렬 기준을 바꿔줘야함 (음수 : 오름차순, 0 : 같은 숫자, 양수 : 내림차순)
         */

        System.out.println(pq.peek());
    }
    
}
