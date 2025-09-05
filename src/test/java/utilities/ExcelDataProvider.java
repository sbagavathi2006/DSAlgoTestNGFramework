package utilities;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	 static {
	        // Load Excel data once at class load
	        ExcelReaderFillo.loadExcelData();
	    }
	 
    @DataProvider(name = "homeDDTestData")
    public Object[][] homeDDTestData(){    	
        return ExcelReaderFillo.getExcelDataFromSheet("HomeDD"); //Calling a method from ExcelReaderFillo class
    }
    
    @DataProvider(name = "homeFlexTestData")
    public Object[][] homeFlexTestData() {
        return ExcelReaderFillo.getExcelDataFromSheet("HomeFlex"); //Calling a method from ExcelReaderFillo class
    }

    @DataProvider(name = "validLoginCredentials")
    public Object[][] validLoginCredentials(){  	
    	return (Object[][]) ExcelReaderFillo.getTestDataFromValidationTypes("login", "ValidCredential");
    }
    
    @DataProvider(name = "testDataWrongUserName")
    public Object[][] testDataWrongUserName(){  	
    	return (Object[][]) ExcelReaderFillo.getTestDataFromValidationTypes("login", "WrongUserName");
    }
    
    @DataProvider(name = "testDataWrongPwd")
    public Object[][] testDataWrongPwd(){  	
    	return (Object[][]) ExcelReaderFillo.getTestDataFromValidationTypes("login", "WrongPwd");
    }
    
    @DataProvider(name = "testDataEmptyPwd")
    public Object[][] testDataEmptyPwd(){  	
    	return (Object[][]) ExcelReaderFillo.getTestDataFromValidationTypes("login", "EmptyPwd");
    }
    
    @DataProvider(name = "testDataEmptyUserName")
    public Object[][] testDataEmptyUserName(){  	
    	return (Object[][]) ExcelReaderFillo.getTestDataFromValidationTypes("login", "EmptyUserName");
    }
}
