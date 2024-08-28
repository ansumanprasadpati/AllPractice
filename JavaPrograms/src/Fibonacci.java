public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=0, n1=1, n2, count=10;
		System.out.print(n+" "+n1);
		for(int i=0;i<count;i++)
		{
			n2=n+n1;
		//		0+1=1(n2)
		//		1+1=2 (n2)
		//		1+2=3 (n2)	
		//		2+3=5 (n2)	
			System.out.print(" "+ n2);
			n=n1; //n=1, //n=1, n=2, 3
			n1=n2;//n1=1,//n1=2,n1=3, 5
			
		}

	}

}
