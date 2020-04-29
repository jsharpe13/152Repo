import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * holds the hashmap that holds the passwords and card numbers
 * @author Jacob Sharpe
 * @version Java 8
 */
public class peopleMap 
{
	Scanner input = new Scanner(System.in);
	HashMap<Integer, String>password; //card, password
	
	/**
	* constructor that calls for the creation of the default passwords and card numbers
	*/
	public peopleMap()
	{
		password = new HashMap<Integer, String>();
		passwordInSystem();
	}
	/**
	 * creates the default passwords and card numbers
	*/
	public void passwordInSystem()
	{
		password.put(1, "a");
		password.put(2, "b");
		password.put(3, "c");
		password.put(4, "d");
	}
	/**
	 * checks to see if a card number exists before returning true or false
	 * @param card number
	*/
	public boolean cardExists(String cardNum)
	{
		boolean exists = true;
		try
		{
			int numberOnCard = Integer.parseInt(cardNum);
			
			String card = password.get(numberOnCard);
			
			if(card == null)
			{
				exists = false;
			}
			
		}
		catch (NumberFormatException e)
		{
			exists = false;
		}	
		return exists;
	}
	/**
	 * gets the password of card number requested
	 * @param cardNum
	*/
	public String getPassword(String cardNum)
	{
		int numberOnCard = Integer.parseInt(cardNum);
		
		String pass = password.get(numberOnCard);
		
		return pass;
	}
	/**
	 * output the JFrame for the person to enter in a new card number
	*/
	public void newPassword()
	{
		JFrame frame = new JFrame("GUI");
		JPanel panel = new JPanel();
		frame.setSize(350, 110);
		panel.setPreferredSize(new Dimension(300, 110));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel enter = new JLabel("Please enter your card number");
		enter.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(enter);
		JTextField cardField = new JTextField();
		cardField.setMaximumSize(new Dimension(200,25));
		cardField.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(cardField);
		JButton ok = new JButton("Ok");
		ok.setAlignmentX(Component.CENTER_ALIGNMENT);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newCardNum = cardField.getText();
				
				try
				{
					int newCardNumber = Integer.parseInt(newCardNum);
					if(password.containsKey(newCardNumber))
					{
						enter.setText("That number already exist. Please use another one");
					}
					else
					{
						frame.dispose();
						newPassInput(newCardNumber);
					}
				}
				catch (Exception e1)
				{
					errorMessage();
				}
			}
		});
		panel.add(ok);
		frame.add(panel);
		frame.setVisible(true);
	}
	/**
	 * JFrame asking for the password and adds it to the password list
	 * @param newCardNumber
	*/
	public void newPassInput(int newCardNumber)
	{
		JFrame frame = new JFrame("GUI");
		JPanel panel = new JPanel();
		frame.setSize(350, 110);
		panel.setPreferredSize(new Dimension(300, 110));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		JLabel enter = new JLabel("Enter a password to use");
		enter.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(enter);
		JTextField cardField = new JTextField();
		cardField.setMaximumSize(new Dimension(200,25));
		cardField.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(cardField);
		JButton ok = new JButton("Ok");
		ok.setAlignmentX(Component.CENTER_ALIGNMENT);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newCardPassword  = cardField.getText();
				
				password.put(newCardNumber, newCardPassword);
				frame.dispose();
				successMessage();
				
			}
		});
		panel.add(ok);
		
		frame.add(panel);
		frame.setVisible(true);
	}
	/**
	 * outputs a JFrame to the user if something goes wrong with the card creation
	*/
	public void errorMessage()
	{	
		JFrame frame = new JFrame("GUI");
		JPanel panel = new JPanel();
		frame.setSize(450, 110);
		panel.setPreferredSize(new Dimension(300, 110));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel empty = new JLabel(" ");
		empty.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel enter = new JLabel("A problem occured. Please make sure the card you entered is a number");
		enter.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(empty);
		panel.add(enter);
		frame.add(panel);
		frame.setVisible(true);
	}
	/**
	 * outputs a JFrame of the success if the card creation was done successfully
	*/
	public void successMessage()
	{	
		JFrame frame = new JFrame("GUI");
		JPanel panel = new JPanel();
		frame.setSize(450, 110);
		panel.setPreferredSize(new Dimension(300, 110));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel empty = new JLabel(" ");
		empty.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel enter = new JLabel("New card and password added");
		enter.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(empty);
		panel.add(enter);
		frame.add(panel);
		frame.setVisible(true);
	}
	
}
