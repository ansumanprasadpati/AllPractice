import java.util.ArrayList;
import java.util.HashSet;

public class UniqueElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,6,3,6,4,9,3,7,2,9,3,7,3,7};
		ArrayList<Integer> al=new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++)
		{
			int k=0;
			if(!al.contains(arr[i]))
			{
				al.add(arr[i]);
				k++;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					k++;
				}
			}
			if(k==1)
			System.out.println(arr[i]+ "is the unique number");
		}

	}

}
}