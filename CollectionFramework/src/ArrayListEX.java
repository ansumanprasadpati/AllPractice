import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		al.add("Ansuman");
//		al.add("java");
//		al.add("python");
//		al.add("cypress");
//		System.out.println(al);
//		al.remove(2);
//		System.out.println(al);
		Integer[] array= {13,5,77,43,90};
		ArrayList<Integer> al=new ArrayList<Integer>(Arrays.asList(array));
		al.remove(1);
		System.out.println(al);
		Collections.sort(al);
		System.out.println(al);
	}

}
