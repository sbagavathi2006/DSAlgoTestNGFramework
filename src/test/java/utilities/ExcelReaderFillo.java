package utilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelReaderFillo{
	private static Map<String, String[]> sheetHeaders = new HashMap<>();
	private static Map<String, Object[][]> sheetDataCache = new HashMap<>();
	private static boolean isDataLoaded = false;
	
	
	//Load test data from all sheets into memory
	
	public static void loadExcelData() {
		if(isDataLoaded) return;	 // if already loaded, exit early
	        Connection connection = null;
	        Recordset recordset = null;
      
	        try {
		        Fillo fillo = new Fillo();
                connection = fillo.getConnection(Constants.TESTDATAPATH);
                                
                //Get all sheets
                
                for(String sheetName : connection.getMetaData().getTableNames()) {
                    recordset = connection.executeQuery("select * from "+ sheetName);
                    int numOfRows = recordset.getCount();
                    int numOfColumns = recordset.getFieldNames().size();
                    Object[][] testData = new Object [numOfRows][numOfColumns];
                    
                 // Save headers once per sheet
                    
                    String[] headers = recordset.getFieldNames().toArray(new String[0]);
                    sheetHeaders.put(sheetName, headers);

                    int row = 0;
                    while (recordset.next()) {
                        int col = 0;
                        for (String fieldName : recordset.getFieldNames()) {
                        	testData[row][col] = recordset.getField(fieldName); // put value in right cell
                            col++;
                        }
                        row++;
                    }
                    
                    sheetDataCache.put(sheetName, testData);
                    recordset.close();
                }
                
                isDataLoaded = true;
                
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (recordset != null) {
                    recordset.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
                      
	    }
		
	//Retrieve test data for a specific sheet
	
	public static Object[][] getExcelDataFromSheet(String sheetName){
//		if(!isDataLoaded) {
//			loadExcelData();
//		}
		return sheetDataCache.get(sheetName);
		}
	
	
	//Load test data based on validation types
	public static Object[][] getTestDataFromValidationTypes(String sheetName, String validationType) {
			Object[][] arr = sheetDataCache.get(sheetName);
			int numRows = arr.length;
		
		    // Temporary list to collect matching rows
		    List<Object[]> matchedRows = new java.util.ArrayList<>();

			for(int i = 0; i < numRows; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					if(arr[i][j] .equals(validationType)){
		                matchedRows.add(arr[i]);  // collect row
		                break; // row matched, go to next row
					}
				}
			}
			
		    // Convert list back to Object[][]
			
			 Object[][] result = new Object[matchedRows.size()][];
			    for (int i = 0; i < matchedRows.size(); i++) {
			        result[i] = matchedRows.get(i);
			    }
			    return result;
		}
	
	public static Map<String, String> getRowAsMap(String sheetName, String validationType) {
	    Object[][] arr = sheetDataCache.get(sheetName);
	    String[] headers = sheetHeaders.get(sheetName);

	    if (arr == null || arr.length == 0) {
	        return new HashMap<>();
	    }

	    for (Object[] row : arr) {
	        for (Object cell : row) {
	            if (cell.toString().equals(validationType)) {
	                Map<String, String> map = new HashMap<>();
	                for (int col = 0; col < headers.length; col++) {
	                    map.put(headers[col], row[col].toString());
	                }
	                return map; // first matching row
	            }
	        }
	    }
	    return new HashMap<>();
	}
	
	public static String validLoginUser() {
		Map<String, String> validCred = ExcelReaderFillo.getRowAsMap("login", "ValidCredential");
		String validUser = validCred.get("username");
		return validUser;
	}


	}
