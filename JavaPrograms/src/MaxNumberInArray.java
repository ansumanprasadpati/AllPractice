
public class MaxNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  array= {800,23,77,33,32,6,100};
		int max=array[0];
		for (int i=0;i<array.length;i++)
		{
			if(array[i]>max) {
				max=array[i];
			}
		}
		System.out.println(max);
	}

}
