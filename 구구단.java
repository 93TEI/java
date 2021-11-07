
// 자바 문법 연습할겸 구구단 코드짜기 + 일부러 오버로딩 사용해서 연습
public class gugu {
	
	int num;
	int numEnd;
	
	public gugu(int num)
	{
		this.num = num;
		this.start(num);
	}
	
	public gugu(int num, int numEnd)
	{
		this.num=num;
		this.numEnd=numEnd;
		this.start2(num, numEnd);
	}
	
	public void start(int num)
	{
		System.out.println("**입력한 " + num + "의 구구단입니다.**");
		for(int i=1; i<10; i++)
		{
			System.out.println(num + " x " + i + " = " + num*i);
		}
	}
	
	public void start2(int num, int numEnd)
	{
		System.out.println("**입력한 " + num + "부터 "+numEnd+ "까지의 구구단입니다.**");
		for(int i=num; i<numEnd+1; i++)
		{
			System.out.println("==="+i+"단 시작===");
			for(int j=1;j<10;j++)
			{
				System.out.println(i + " x " + j + " = " + j*i);
			}
		}
	}
	
	public static void main(String[] args) {
		gugu temp = new gugu(2);
		gugu temp1 = new gugu(2,4);
	}
}
