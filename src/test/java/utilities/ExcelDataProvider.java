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
    	return ExcelReaderFillo.getTestDataFromValidationTypes("login", "ValidCredential");
    }
    
    @DataProvider(name = "testDataWrongUserName")
    public Object[][] testDataWrongUserName(){  	
    	return ExcelReaderFillo.getTestDataFromValidationTypes("login", "WrongUserName");
    }
    
    @DataProvider(name = "testDataWrongPwd")
    public Object[][] testDataWrongPwd(){  	
    	return ExcelReaderFillo.getTestDataFromValidationTypes("login", "WrongPwd");
    }
    
    @DataProvider(name = "testDataEmptyPwd")
    public Object[][] testDataEmptyPwd(){  	
    	return ExcelReaderFillo.getTestDataFromValidationTypes("login", "EmptyPwd");
    }
    
    @DataProvider(name = "testDataEmptyUserName")
    public Object[][] testDataEmptyUserName(){  	
    	return ExcelReaderFillo.getTestDataFromValidationTypes("login", "EmptyUserName");
    }
    
    @DataProvider(name = "testDataEmptyCodeEditor")
    public Object[][] testDataEmptyCodeEditor(){  	
    	return ExcelReaderFillo.getTestDataFromValidationTypes("arrayTryEditor", "EmptyCodeEditor");
    }
    
    @DataProvider(name = "testDataInvalidCodeRunEditor")
    public Object[][] testDataInvalidCodeRunEditor(){  	
    	return ExcelReaderFillo.getTestDataFromValidationTypes("arrayTryEditor", "InvalidCodeRun");
    }
    
    @DataProvider(name = "testDataValidCodeRunEditor")
    public Object[][] testDataValidCodeRunEditor(){  	
    	return ExcelReaderFillo.getTestDataFromValidationTypes("arrayTryEditor", "ValidCodeRun");
    }
    
    @DataProvider(name = "testDataExistingCodSnippet")
    public Object[][] testDataExistingCodSnippet(){  	
    	return ExcelReaderFillo.getTestDataFromValidationTypes("arrayPracticeQns", "ExistingCodeSnippet");
    }
    
    @DataProvider(name = "testDataInvalidCodSnippet")
    public Object[][] testDataInvalidCodSnippet(){  	
    	return ExcelReaderFillo.getTestDataFromValidationTypes("arrayPracticeQns", "InvalidCodeSnippet");
    }
    
    @DataProvider(name = "testDataValidCodSnippet")
    public Object[][] testDataValidCodSnippet(){  	
    	return ExcelReaderFillo.getTestDataFromValidationTypes("arrayPracticeQns", "ValidCodeSnippet");
    }
    
    @DataProvider(name = "testDataGraphEmptyCodeEditor")
    public Object[][] testDataGraphEmptyCodeEditor(){  	
    	return ExcelReaderFillo.getTestDataFromValidationTypes("graphTryEditor", "EmptyCodeEditor");
    }
    
    @DataProvider(name = "testDataGraphInvalidCodeRunEditor")
    public Object[][] testDataGraphInvalidCodeRunEditor(){  	
    	return ExcelReaderFillo.getTestDataFromValidationTypes("graphTryEditor", "InvalidCodeRun");
    }
    
    @DataProvider(name = "testDataGraphValidCodeRunEditor")
    public Object[][] testDataGraphValidCodeRunEditor(){  	
    	return ExcelReaderFillo.getTestDataFromValidationTypes("graphTryEditor", "ValidCodeRun");
    }
 
}
