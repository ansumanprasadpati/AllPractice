import java.util.Scanner;

public class Pali {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rev="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string");
		String str=sc.next();
		for(int i=str.length()-1;i>=0;i--)
		{
			rev=rev+str.charAt(i);
		}
		if(rev.equalsIgnoreCase(str))
		{
			System.out.println("pallindrome");
		}
		else
		{
			System.out.println("not palindrome");
		}

	}

}
