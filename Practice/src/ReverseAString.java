public class ReverseAString{
	public static void main(String[] args)
	{
		String str="Ansu";
		String rev="";
		for(int i=0;i<str.length();i++)
		{
			rev=str.charAt(i)+rev;
		}
		System.out.println(rev);
		if(str.equalsIgnoreCase(rev))
		{
			System.out.println("its palindrome");
		}else
		{
			System.out.println("its not palindrome");
		}
	}
}