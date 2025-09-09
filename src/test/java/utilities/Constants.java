package utilities;

public class Constants {
	
	public static final String BROWSER = ConfigReader.getProperty("browser");
	public static final String APPURL = ConfigReader.getProperty("url");
	public static final String TESTDATAPATH = ConfigReader.getProperty("testDataPath");
	public static final String ARR_IN_PHYTHON_TITLE = "Arrays in Python";
	public static final String ARR_USING_LIST_TITLE = "Arrays Using List";
	public static final String ARR_BASIC_LISTS_TITLE = "Basic Operations in Lists";
	public static final String ARR_APPLNS_ARR_TITLE = "Applications of Array";
	public static final String PRACTICE_QNS_LINK_TITLE = "Practice Questions";
	public static final String TRY_HERE_BTN_TITLE = "Assessment";
	public static final int PRAC_QN_NUM1 = 1;
	public static final int PRAC_QN_NUM2 = 2;
	public static final int PRAC_QN_NUM3 = 3;
	public static final int PRAC_QN_NUM4 = 4;
	public static final String GRAPH_GRAPH_TITLE = "Graph";
	public static final String GRAPH_GRAPH_REP_TITLE = "Graph Representations";
	public static final String QUEUE_IMP_OF_QUE_IN_PYTHON = "Implementation of Queue in Python";
	public static final String QUEUE_IMP_USING_COLLE = "Implementation using collections.deque";
	public static final String QUEUE_IMP_USING_ARR = "Implementation using array";
	public static final String QUEUE_QUEUE_OPER = "Queue Operations";



	//private since this constructor is just a container for static values, Never create an Object.
	private Constants() {
		
	}
}
