
public class CheckForPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=20;
		boolean primeNum=true;
		for(int i=0;i<Math.sqrt(n);i++)
		{
			if(n%2==0)
			{
				primeNum=false;
				break;
			}
		}
		if(primeNum)
		{
			System.out.println(n+" is a prime number.");
		}
		else
			{
				System.out.println(n+" is not a prime number");
			}
		}

	}
