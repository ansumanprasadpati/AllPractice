import java.util.HashSet;

public class RemoeDuplicatesFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="ansuman";
		HashSet<Character> set=new HashSet<>();
		StringBuilder sb=new StringBuilder();
		for(char c:str.toCharArray())//converting string to char Array
		{
			if(!set.contains(c))
			{
				set.add(c);
				sb.append(c);
			}
		}
		String afterRemoval=sb.toString();
		System.out.println(afterRemoval);
			

	}

}
