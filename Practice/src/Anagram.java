import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="vase";
		String str2="save";
		char[] c1=str1.toCharArray();
		char[] c2=str2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if(Arrays.equals(c1, c2))
		{
			System.out.println("Anagrams");
		}else
		{
			System.out.println("Not anagrams");
		}

	}

}
