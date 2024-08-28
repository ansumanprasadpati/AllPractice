import java.util.HashSet;

public class FindDuplicatesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3,5,2,2,4,1,4,5};
		HashSet<Integer> duplicates=new HashSet<Integer>();
		HashSet<Integer> seen=new HashSet<Integer>();
		for(int num:arr)
		{
			if(!seen.add(num))
			{
				duplicates.add(num);
			}
		}System.out.println("duplicates are"+duplicates);
	}

}
