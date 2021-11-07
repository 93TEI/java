public class MultiplesOf3and5 {
	
	static class mutipleOfNum{
		int num;
		int num2;
		int result=0;
		
		public mutipleOfNum(int num,int num2) {
			this.num = num;
			this.num2=num2;
			this.cal();
		}
		
		public int cal()
		{
			for(int i=0;i<1000;i++)
			{
				if(i%3==0 || i%5==0)
					result +=i;
			}
			return result;
		}
	}
	
	public static void main(String[] args) {
		//10 미만의 자연수에서 3과 5의 배수를 구하면 3, 5, 6, 9이다. 이들의 총합은 23이다. 1000미만의 자연수에서 3, 5의 배수의 총합을 구하라.
		mutipleOfNum calNum = new mutipleOfNum(3, 5);

		System.out.println(calNum.cal());
	}

}
