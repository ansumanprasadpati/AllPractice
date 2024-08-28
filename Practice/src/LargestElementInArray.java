
public class LargestElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,5,7,9};
		int max=arr[0];
		for(int num=0;num<arr.length;num++)
		{
			if(arr[num]>max)
			{
				max=arr[num];
			}
		}System.out.println(max);

	}

}
