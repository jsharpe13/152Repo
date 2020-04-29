import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 * test class when initally doing GUI
 * @author Jacob Sharpe
 * @version Java 8
 */
public class testClass 
{
	/**
	 * test method for various GUI concepts
	 */
	public void testMethod()
	{
		JFrame frame2 = new JFrame("GUI");
		frame2.setSize(500,300);
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JTextField jt = new JTextField(30);
		frame2.add(jt);
		frame2.setVisible(true);
	}
}
