import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * class for the entering passwords
 * @author Jacob Sharpe
 * @version Java 8
 */
public class password 
{
	peopleMap pm;
	takeOutBook2 tob2;
	
	
	Scanner input = new Scanner(System.in);
	String cardNum;
	String passInput;
	boolean success;
	int attempts;
	
	/**
	*constructor that passes in the peopleMap class and the take out class
	*@param passwords
	*@param take
	*/
	public password(peopleMap passwords, takeOutBook2 take)
	{
		pm = passwords;
		tob2 = take;
		cardNum = "";
		passInput = "";
		attempts = 0;
	}
	
	/**
	*takes in the card number for the check out portion of the program
	*/
	public boolean checkPassword()
	{
		JFrame frame = new JFrame("GUI");
		JPanel panel = new JPanel();
		frame.setSize(350, 110);
		panel.setPreferredSize(new Dimension(300, 110));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		cardNum = "";
		passInput = "";
		success = false;
		attempts = 0;

		
		JLabel enter = new JLabel("Please enter your card Number");
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
				cardNum = cardField.getText();
				
				if(pm.cardExists(cardNum) != true)
				{
					enter.setText("I'm sorry that card does not exist. Please try another one");
				}
				else
				{
					frame.dispose();
					inputPassword();
				}
			}
		});
		panel.add(ok);
		
		frame.add(panel);
		frame.setVisible(true);
		return success;
		
	}
	/**
	*takes in the password and check it for the take out portion of the program
	*/
	public void inputPassword()
	{
		success = false;
		String pass = pm.getPassword(cardNum);
		passInput = "";
		attempts = 0;
		
		JFrame frame = new JFrame("GUI");
		JPanel panel = new JPanel();
		frame.setSize(375, 110);
		panel.setPreferredSize(new Dimension(300, 110));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel enter = new JLabel("Please Input Password");
		enter.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(enter);
		JTextField passField = new JTextField();
		passField.setMaximumSize(new Dimension(200,25));
		passField.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(passField);
		JButton ok = new JButton("Ok");
		ok.setAlignmentX(Component.CENTER_ALIGNMENT);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				passInput = passField.getText();
				
				if(attempts < 2)
				{
					if(!passInput.equals(pass))
					{
						attempts++;
						enter.setText("The password you have entered is incorrect please try again");
					}
					else if(passInput.equals(pass))
					{
						success = true;
						frame.dispose();
						//PLACE HERE
						tob2.findAndAddBook(cardNum);
					}
				}
				else
				{
					success = false;
					frame.dispose();
					toomanyAttempts();
				}
			}
		});
		panel.add(ok);
		
		frame.add(panel);
		frame.setVisible(true);
	}
	/**
	*this is where the user is sent to if there are too many attempts
	*notifys the user and closes everything upon exit
	*/
	public void toomanyAttempts()
	{
		success = false;
		
		JFrame frame = new JFrame("GUI");
		JPanel panel = new JPanel();
		frame.setSize(450, 110);
		panel.setPreferredSize(new Dimension(300, 110));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel empty = new JLabel(" ");
		empty.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel enter = new JLabel("I'm sorry you have tried too many times. Please try again later.");
		enter.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(empty);
		panel.add(enter);
		frame.add(panel);
		frame.setVisible(true);
	}

//---------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------
	//For returning books
	/**
	*takes in the card number for the return books part of the program
	*/
	public boolean checkPasswordReturn()
	{
		JFrame frame = new JFrame("GUI");
		JPanel panel = new JPanel();
		frame.setSize(350, 110);
		panel.setPreferredSize(new Dimension(300, 110));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		cardNum = "";
		passInput = "";
		success = false;
		attempts = 0;

		
		JLabel enter = new JLabel("Please enter your card Number");
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
				cardNum = cardField.getText();
				
				if(pm.cardExists(cardNum) != true)
				{
					enter.setText("I'm sorry that card does not exist. Please try another one");
				}
				else
				{
					frame.dispose();
					inputPasswordReturn();
				}
			}
		});
		panel.add(ok);
		
		frame.add(panel);
		frame.setVisible(true);
		return success;
		
	}
	/**
	*takes in the password and check it for the return part of the program
	*/
	public void inputPasswordReturn()
	{
		success = false;
		String pass = pm.getPassword(cardNum);
		passInput = "";
		attempts = 0;
		
		JFrame frame = new JFrame("GUI");
		JPanel panel = new JPanel();
		frame.setSize(375, 110);
		panel.setPreferredSize(new Dimension(300, 110));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel enter = new JLabel("Please Input Password");
		enter.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(enter);
		JTextField passField = new JTextField();
		passField.setMaximumSize(new Dimension(200,25));
		passField.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(passField);
		JButton ok = new JButton("Ok");
		ok.setAlignmentX(Component.CENTER_ALIGNMENT);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				passInput = passField.getText();
				
				if(attempts < 2)
				{
					if(!passInput.equals(pass))
					{
						attempts++;
						enter.setText("The password you have entered is incorrect please try again");
					}
					else if(passInput.equals(pass))
					{
						success = true;
						frame.dispose();
						//PLACE HERE
						//TODO
						//System.out.println(cardNum);
						tob2.returnBooks(cardNum);
					}
				}
				else
				{
					success = false;
					frame.dispose();
					toomanyAttempts();
				}
			}
		});
		panel.add(ok);
		
		frame.add(panel);
		frame.setVisible(true);
	}
}
