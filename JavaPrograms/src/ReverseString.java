
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String actual_String="Ansuman";
		String rev_String="";
		//char ch; //for extracting each character;
		
		for(int i=0;i<actual_String.length();i++)
		{
			//ch=actual_String.charAt(i);
			rev_String=actual_String.charAt(i)+rev_String;
		}
		System.out.println(rev_String);

	}
//	public static String reversedString(String str)
//	{
//		StringBuilder sb=new StringBuilder();
//		return sb.reverse().toString();
//	}
	

}
