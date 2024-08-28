import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1x2x3x4x5...xN
		double fact=1;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the number:");
			double num =sc.nextInt();
			
			for(int i=1;i<=num;i++)
			{
				fact=fact*i;
			}
		}
		System.out.println("The factorial is:"+ fact);
	}

}
