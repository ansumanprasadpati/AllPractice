import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,1,1,4,6,7,8,3,2};
		int[] arr1= {2,4,1,5,3,8,8,9};
		HashSet<Integer> set=new HashSet<>();
		HashSet<Integer> common=new HashSet<>();
		for(int value:arr)
		{
			set.add(value);
		}
		System.out.println(set);
		for(int val:arr1)
		{
			//common.add(val);
			if(set.contains(val))
			{
				common.add(val);
			}
		}
		System.out.println(common);

	}

}
