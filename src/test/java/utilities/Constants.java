package utilities;

public class Constants {
	
	public static final String BROWSER = ConfigReader.getProperty("browser");
	public static final String APPURL = ConfigReader.getProperty("url");
	public static final String TESTDATAPATH = ConfigReader.getProperty("testDataPath");

	//private since this constructor is just a container for static values, Never create an Object.
	private Constants() {
		
	}
}
