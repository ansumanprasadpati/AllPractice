import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] arr1= {"java", "python", "java", "sql","ruby","selenium", "cypress"};
		String [] arr2= {"python", "selenium", "java", "sql", "python"};
		HashSet<String> set1=new HashSet<String>();
		HashSet<String> set2= new HashSet<String>();
		for(String val1:arr1)
		{
			set1.add(val1);
		}
		System.out.println(set1);
		// common between 2 arrays
		for(String val2:arr2)
		{
			if(set1.contains(val2))
			{
				set2.add(val2);
			}
		}
		System.out.println(set2);
		

	}

}
