package new_Demo;

import FIles.payloadBody;
import io.restassured.path.json.JsonPath;
 
public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath jsp= new JsonPath(payloadBody.CoursePrice());
		
		// show the course count
		int count= jsp.getInt("courses.size()");
		System.out.println(count);
		//show the purchase amount
		int courseAmount=jsp.getInt("dashboard.purchaseAmount");
		System.out.println(courseAmount);
		//show the title
		String title=jsp.get("courses.title[0]");
		System.out.println(title);
		
		//print title name and price of the course.
		for(int i=0;i<count;i++)
		{
			String c_Name=jsp.get("courses.title["+i+"]");
			System.out.println(jsp.get("courses.price["+i+"]").toString());
			System.out.println("Course_Name:"+c_Name);
		}
		System.out.println("*****************************");
		for(int i=0;i<count;i++)
		{
			String c_Name=jsp.get("courses.title["+i+"]");
			if (c_Name.equalsIgnoreCase("RPA"))
			{
				int copy=jsp.get("courses["+i+"].copies");
				System.out.println(copy);
				break;
			}
			
		}
		System.out.println("*****__________*****");
		
		for(int i=0;i<count;i++)
		{
			//String c_Name=jsp.get("courses.title["+i+"]");
			int price=jsp.get("courses.price["+i+"]");
			int copies=jsp.getInt("courses["+i+"].copies");
			int cartAmount=price*copies;
			System.out.println(cartAmount);
		}
	}

}
