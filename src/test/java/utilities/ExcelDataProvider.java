package utilities;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	ExcelReaderFillo data = new ExcelReaderFillo();
	
    @DataProvider(name = "homeDDTestData")
    public Object[][] homeDDTestData() {
        return data.getExcelDataFromSheet("HomeDD"); //Calling a method from ExcelReaderFillo class
    }
    
    @DataProvider(name = "homeFlexTestData")
    public Object[][] homeFlexTestData() {
        return data.getExcelDataFromSheet("HomeFlex"); //Calling a method from ExcelReaderFillo class
    }

}
