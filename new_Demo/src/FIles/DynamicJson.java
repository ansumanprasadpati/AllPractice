package FIles;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

//import java.util.Scanner;

public class DynamicJson {
	
	//Scanner sc=new Scanner(System.in);
	//String isbn=sc.nextLine();
	//String aisle=sc.nextLine();
	private String id;
	@Test(dataProvider="bookDetails")
	public void addBook(String isbn, String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String Add_Book=given().log().all().header("Content-type","application/json")
				.body(payloadBody.addBook(isbn, aisle))
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js=ReUsableMethods.RawtoJson(Add_Book);
		id=js.get("ID");
		System.out.println(id);
	}
	public void deleteBook()
	{
		RestAssured.baseURI="http://216.10.245.166";
		given().log().all().header("Content-type", "application/json")
		.body(payloadBody.deleteBook(id))
		.when().delete("/Library/DeleteBook.php")
		.then().assertThat().statusCode(200);
	}
	
	@DataProvider(name="bookDetails")
	public Object[][] getData()
	{
		return new Object[][]{{"aaa","111"},{"bbb","222"},{"ccc","333"}};
	}

}
