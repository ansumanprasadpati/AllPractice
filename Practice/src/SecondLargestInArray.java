public class SecondLargestInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {23,55,739,88,12};
		int firstLargest=Integer.MIN_VALUE;
		int secondLargest=Integer.MIN_VALUE;
		for(int num:arr)
		{
			if(num>firstLargest) {
			secondLargest=firstLargest;
			firstLargest=num;
			}
			else if(num>secondLargest && num!=firstLargest)
			{
				secondLargest=num;
			}
		}
		System.out.println(secondLargest);

	}

}
