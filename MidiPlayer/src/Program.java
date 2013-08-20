/**
 * 
 */
public class Program
{
	//  =============================================

	private MainWindow mMainWindow; 


	//  =============================================

	/**
	 * 
	 */
	public Program() {

		// 
		mMainWindow = new MainWindow();

		// 
		mMainWindow.show();
	}

	/**
	 * 
	 *
	 * @param args 
	 */
	public static void main( String[] args ) {
		// 
		Program instance = new Program();
	}

}