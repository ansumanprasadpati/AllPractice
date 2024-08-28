package new_Demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import FIles.payloadBody;
import io.restassured.path.json.JsonPath;
public class CartTotal{

@Test
public void SumValidation ()
{
	JsonPath js= new JsonPath(payloadBody.CoursePrice());
	int sum=0;
	int count= js.getInt("courses.size()");
	for(int i=0;i<count;i++)
	{
		int price=js.getInt("courses["+i+"].price");
		int copies=js.getInt("courses["+i+"].copies");
		int cartAmount=price*copies;
		System.out.println(cartAmount);
		sum=sum+cartAmount;
	}
	int cartTotal=js.getInt("dashboard.purchaseAmount");
	Assert.assertEquals(sum, cartTotal);

}
}
