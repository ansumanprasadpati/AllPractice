import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean isPrime=true;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter any number:");
		int num=sc.nextInt();
		for (int i=2;i<num/2;++i)
		{
			if(num%i==0)
				isPrime=false;
			break;
		}
		if(isPrime) {
		System.out.println(num+" is prime number");
		}
		else
		{
			System.out.println(num+"is not a prime number");
		}
	}
}
	
