package Utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FetchValueFromExcel {
	
	
	public static Map createUser() throws IOException
	{
		
		
		
		String excelPath="src\\test\\java\\TestData\\CreateNewUser.xlsx";
		String sheetName="Sheet1";
		ReadDataFromExcel obj=new ReadDataFromExcel(excelPath,sheetName);
		
		Map<Object,Object>mp=new HashMap<Object,Object>();
		
		mp.put("name",obj.getTestData(1,0));
		mp.put("gender",obj.getTestData(1,1));
		mp.put("email",GenerateRandomEmail.generateRandomEmail());
		mp.put("status",obj.getTestData(1,3));
		return mp;

}
	
}
