import java.util.Scanner;

public class Pallindrome {

	public static void main(String[] args) {
	/*	System.out.println(isPalindrome());
		
	}
	public static boolean isPalindrome()
	{
	String str= "Ansuman";
	StringBuilder sb= new StringBuilder(str);
	sb.reverse();
	//System.out.println(reversed_String);
	
	return str.equals(sb.toString());
	}*/
		
	String str="";
	String rev="";
	Scanner s=new Scanner(System.in);
	System.out.println("Enter a String:");
	str=s.nextLine();
	int n= str.length();
	for(int i=n-1;i>=0;i--)
	{
		rev=rev+str.charAt(i);
	}
	if(str.equalsIgnoreCase(rev))
	{
		System.out.println("Palindrome");
	}
	else
	{
		System.out.println("Not Palindrome");
	}

}
}