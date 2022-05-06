/*
 * Thread를 상속받아 구현
 */
class Bread extends Thread {
// 상속받은 Thread의 run() 메소드를 재정의를 해야 Thread의 실행부분 작성 가능
 @Override
 public void run() { // start()가 새로운 Thread가 작업하는데 필요한 호출스택을 생성하는데 run()은 거기에 첫번째로 저장되는 과정
     //super.run(); // 이거 안해도 쓰레드 동작함
     System.out.println("Bread !");
 }
}

/*
 * Runnable 인터페이스로 구현
 * : 대부분 선호하는 방식인데, 다른 클래스 상속받을 수 있어서이지 않을까
 */
class BreadRun implements Runnable {
	@Override
	public void run() {
		System.out.println("Bread-runnable !");
	}
}

/*
 * 주문받는 Order 클래스 (동기화)
 */
class Order implements Runnable {
	
	@Override
	public void run() {
		makeFood();
	}
	
	//synchronized를 메소드에 걸면 메소드를 포함한 this에 락 걸림, synchronized(객체)는 해당 객체만 락을 걸어 다른 스레드가 접근하지 못하게 함
	/*
	락 객체는 문지기 역할을 해서 오직 하나의 스레드만이 동기화 블록에 접근할 수 있다.
	동기화는 락을 필요로 하며 락은 모든 객체마다 존재한다. 메서드 제어자 뒤에 synchronized 키워드가 위치한 동기화 메서드는 락 객체를 지정하는 부분이 없다.
	동기화 메서드는 내부적으로 자신의 객체를 락으로 사용한다. 즉, 객체 스스로 메서드 전체를 감시하는 역할을 한다. 이에 반해서 동기화 블록(sync(obj))은 메서드 안의 특정 부분을 동기화할 수 있다.
	이런 경우에 락 객체는 자기 자신 객체를 의미하는 this 키워드를 사용할 수도 있지만 다른 객체를 락으로 사용할 수 있다.
	단, 락 객체가 여러 개라면 우리가 원하는 동기화 작업을 제대로 실행할 수 없다.
	그래서 보통은 락 객체를 하나만 사용하는 경우가 많다. 동기화 블록을 사용하는 경우, 해당 메서드는 여러 스레드가 동시에 점유할 수 있다.
	하지만 동기화된 블록에 이르면 락 객체에 의해서 모든 스레드들은 실행을 중단하고 자신의 차례가 될 때까지 대기한다.
	*/
	public static synchronized void makeFood() {
		while(true) {
			// Order가 들어왔을 때 먼저 들어간 주문의 음식이 나오기 전까지
			// 앞 주문의 음식이 만들어지지 않게 한다.
			//System.out.print("1");
		}
	}
}

class ThreadWaiting implements Runnable {
	  @Override
	  public void run() {
		  while (!Thread.currentThread().isInterrupted()) {
			  try {
		        // do something
		        Thread.sleep(100);
		        System.out.println("waitingTest");
		      } catch (InterruptedException ex) {
		        Thread.currentThread().interrupt();
		        System.out.println("interrupt");
	      }
	    }
	  }
	}

public class thread{

 public static void main(String[] args) throws InterruptedException {
	 
	 // Waiting 확인부
     Thread waitingTest = new Thread(new ThreadWaiting());
     waitingTest.start();
     System.out.println("waitingTest : "+waitingTest.getState());
     
     // Bread 구현 확인부
	 Bread bread = new Bread();
     Thread breadRun = new Thread(new BreadRun());
     System.out.println(breadRun.getId()+", "+breadRun.getName()+", "+breadRun.getPriority()+", "+breadRun.getState());
     breadRun.setPriority(10); // 우선순위 설정, 범위 : 0~10, 10이 최우선순위
     breadRun.setName("MyThread");
     bread.start(); // start() 메소드를 호출하면 thread가 실행된다. 여기서 start() 메소드는 쓰레드 객체의 run() 메소드를 호출한다.
     breadRun.start();
     System.out.println(breadRun.getId()+", "+breadRun.getName()+", "+breadRun.getPriority()+", "+breadRun.getState());
     
     // order로 인한 runnable 상태와 blocked 상태 확인부
     Thread order = new Thread(new Order());
     Thread orderSecond = new Thread(new Order());
     order.start();
     orderSecond.start();
     
     Thread.sleep(1000);
     
     System.out.println(order.getState());
     System.out.println(orderSecond.getState());
     
     
     // Waiting 확인부 2 
     System.out.println("waitingTest : "+waitingTest.getState()); // TIMED_WAITING
     waitingTest.interrupt();
     System.out.println("waitingTest : "+waitingTest.getState()); // TIMED_WAITING or TERMINATED
     System.exit(0);
 }
}
