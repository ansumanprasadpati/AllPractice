
public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int f=0, f1=1,f2, count=10;
		System.out.print(f+" "+f1);
		for (int i=0;i<=count;i++)
		{
			f2=f+f1;//f2=0+1=1
			System.out.print(" "+ f2);
			f=f1;
			f1=f2;
		}

	}

}
