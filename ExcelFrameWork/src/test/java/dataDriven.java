import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		FileInputStream fis= new FileInputStream("C:\\Users\\ansuman.pati\\Desktop\\Dummy.xlsx");
		XSSFWorkbook xWb=new XSSFWorkbook(fis);
		
		
		int sheets=xWb.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(xWb.getSheetName(i).equalsIgnoreCase("Demo"))
			{
				XSSFSheet sheet=xWb.getSheetAt(i);
			}
		}

	}

}
