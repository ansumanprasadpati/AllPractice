import java.util.Scanner;

public class PrintInitialsOfName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a name: ");
		String name=sc.nextLine();
		String[] init=name.split(" ");
		StringBuilder sb=new StringBuilder();
		for(String str:init)
		{
			sb.append(str.charAt(0)).append(" ");
		}
		System.out.println(sb.toString());
		

	}

}
