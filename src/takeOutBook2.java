import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * class that holds the take out and the return methods for books
 * @author Jacob Sharpe
 * @version Java 8
 */
public class takeOutBook2 
{
	Scanner input = new Scanner(System.in);
	ArrayList<returnBooks>returnList;
	LinkedList<book>checkOutList = new LinkedList<book>();
	book toBeAdded;
	
	LinkedList<waitingBooks> booksOnList = new LinkedList<>();
	
	booklist bl;
	LinkedList<book> ml;
	/**
	 * constuctor that takes in the booklist class
	 * @param bl
	 */
	public takeOutBook2(booklist bl)
	{
		this.bl = bl;
		ml = bl.master;	
		toBeAdded = null;
	}
	/**
	 * JFrame that asks for the title of the book and adds it to the check out list
	 * @param cardNum
	 */
	public void findAndAddBook(String cardNum)
	{
		toBeAdded = null;
		JFrame findBooks = new JFrame("Take Out Books");
		findBooks.setSize(500, 300);
		findBooks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		findBooks.setVisible(true);
		JPanel listPanel = new JPanel();
		listPanel.setPreferredSize(new Dimension(500,300));
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		
		JLabel enter = new JLabel("Please enter the name of the book you want");
		enter.setAlignmentX(Component.CENTER_ALIGNMENT);
		JTextField bookField = new JTextField();
		bookField.setMaximumSize(new Dimension(400,25));
		bookField.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton ok = new JButton("Ok");
		ok.setAlignmentX(Component.CENTER_ALIGNMENT);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean  foundBook = false;
				boolean checkOutAlready = false;
				
				String WantedBook = bookField.getText();
				//System.out.println(WantedBook);
				
				for(int i = 0; i<ml.size(); i++)
				{
					if(WantedBook.equalsIgnoreCase(ml.get(i).title) && ml.get(i).isIn == true)
					{
						ml.get(i).isIn = false;
						ml.get(i).AccountOwner = cardNum;
						checkOutList.add(ml.get(i));
						foundBook = true;
					}
					else if(WantedBook.equalsIgnoreCase(ml.get(i).title) && ml.get(i).isIn == false)
					{
						toBeAdded = ml.get(i);
						foundBook = true;
						checkOutAlready = true;
					}
				}
				
				if(foundBook == false)
				{
					enter.setText("I'm sorry the book you are searching for does not exist in our system");
				}
				else if(foundBook == true)
				{
					if(checkOutAlready == false)
					{
						enter.setText(WantedBook + " added successfully to Account # " + cardNum);
						toBeAdded = null;
					}
					else if(checkOutAlready == true)
					{
						yesOrNo(cardNum);
					}
					
				}
			}
		});
		
		
		listPanel.add(enter);
		listPanel.add(bookField);
		listPanel.add(ok);
		
		findBooks.add(listPanel);
	}
	/**
	 * JFrame that appears if the book user wants is check out
	 * asking if they want to be put on the wait list
	 * @param cardNum
	 */
	public void yesOrNo(String cardNum)
	{
		JFrame frame = new JFrame("GUI");
		JPanel panel = new JPanel();
		frame.setSize(375, 175);
		panel.setPreferredSize(new Dimension(300, 175));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel notavailable = new JLabel("I'm sorry this book is already checked out.");
		notavailable.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(notavailable);
		JLabel putOn = new JLabel("do you want to be put on the waiting list?");
		putOn.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(putOn);
		
		
		JButton yes = new JButton("Yes");
		JButton no = new JButton(" no ");
		yes.setAlignmentX(Component.CENTER_ALIGNMENT);
		yes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				waitingBooks addedBook = new waitingBooks(toBeAdded, cardNum);
				booksOnList.add(addedBook);
				
				notavailable.setText(" ");
				putOn.setText(toBeAdded.title + " added to the wait list for Account # " + cardNum);
				no.setVisible(false);
				yes.setVisible(false);
				toBeAdded = null;
			}
		});
		no.setAlignmentX(Component.CENTER_ALIGNMENT);
		no.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				notavailable.setText(" ");
				putOn.setText("Ok, Thank You. Feel free to continue to browse");
				no.setVisible(false);
				yes.setVisible(false);
			}
		});
		
		JLabel empty1 = new JLabel(" ");
		empty1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(empty1);
		panel.add(yes);
		JLabel empty2 = new JLabel(" ");
		empty2.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(empty2);
		panel.add(no);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	
	/**
	 * puts up all the books a specified account has check out in button form
	 * @param cardNumReturn
	 */
	public void returnBooks(String cardNumReturn)
	{
		returnList = new ArrayList<returnBooks>();
		for(int i = 0; i<checkOutList.size(); i++)
		{
			if(checkOutList.get(i).AccountOwner.equals(cardNumReturn))
			{
				returnBooks rb = new returnBooks(checkOutList.get(i), i);
				returnList.add(rb);
			}
		}
		if(returnList.size() == 0)
		{
			JFrame frame= new JFrame("Return Books");
			frame.setSize(500, 200);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			
			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(500,200));
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			
			JLabel empty = new JLabel(" ");
			empty.setAlignmentX(Component.CENTER_ALIGNMENT);
			JLabel message = new JLabel("This Account has no books checked out");
			message.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			panel.add(empty);
			panel.add(message);
			frame.add(panel);
		}
		else
		{
			JFrame frame= new JFrame("Return Books");
			frame.setSize(500, 700);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			
			JPanel panel = new JPanel();
			panel.setPreferredSize(new Dimension(500,700));
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			
			JLabel empty = new JLabel(" ");
			empty.setAlignmentX(Component.CENTER_ALIGNMENT);
			JLabel message = new JLabel("Which book do you want to return");
			message.setAlignmentX(Component.CENTER_ALIGNMENT);
			JTextField bookField = new JTextField();
			bookField.setMaximumSize(new Dimension(400,25));
			bookField.setAlignmentX(Component.CENTER_ALIGNMENT);
			JLabel empty2 = new JLabel(" ");
			empty2.setAlignmentX(Component.CENTER_ALIGNMENT);
			JButton ok = new JButton("Ok");
			ok.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			
			JButton all = new JButton("Return All");
			all.setAlignmentX(Component.CENTER_ALIGNMENT);
			all.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i = 0; i<returnList.size(); i++)
					{
						
						for(int j = 0; j<checkOutList.size(); j++)
						{
							if(checkOutList.get(j).title.equals(returnList.get(i).Book.title))
							{
								returnList.get(i).Book.AccountOwner = null;
								returnList.get(i).Book.isIn = true;
								checkOutList.remove(j);
							}
						}
					}
					checkAfterReturn();
					frame.dispose();
				}
			});
			
			panel.add(empty);
			panel.add(message);
			panel.add(empty2);
			for(int i= 0; i < returnList.size(); i++)
			{
				int j = i;
				JButton newButton = new JButton(""+ returnList.get(i).Book.title);
				newButton.setAlignmentX(Component.CENTER_ALIGNMENT);
				newButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						book removeBook = returnList.get(j).Book;
						removeBook.AccountOwner = null;
						removeBook.isIn = true;
						checkOutList.remove(returnList.get(j).index);
						checkAfterReturn();
						frame.dispose();	
					}
				});
				
				panel.add(newButton);
				
				JLabel empty3 = new JLabel(" ");
				empty3.setAlignmentX(Component.CENTER_ALIGNMENT);
				panel.add(empty3);
			}
			panel.add(all);
			frame.add(panel);
		}
	}
	
	
	
	/**
	 * checks the waiting list after return is done to see if any of the books
	 * are back in
	 */
	public void checkAfterReturn()
	{
		if(booksOnList.size() != 0)
		{
			for(int i=0; i<booksOnList.size(); i++)
			{
				book search = booksOnList.get(i).Book;
				String cardNum = booksOnList.get(i).AccountWantingBook;
				boolean results = WaitListPlacement(search, cardNum);
				
				if(results = true)
				{
					booksOnList.remove(i);
					i--;
				}
			}
		}
	}
	/**
	 * places the books if they are available on the check out list again for the new account
	 * @param search
	 * @param cardNumWait
	 * @return
	 */
	public boolean WaitListPlacement(book search, String cardNumWait)
	{
		boolean foundBook = false;
		boolean checkOutAlready = false;
		
		for(int i = 0; i< ml.size(); i++)
		{
			if(search.title.equalsIgnoreCase(ml.get(i).title)&& ml.get(i).isIn == true)
			{
				ml.get(i).isIn = false;
				ml.get(i).AccountOwner = cardNumWait;
				checkOutList.add(ml.get(i));
				foundBook = true;
			}
			else if(search.title.equalsIgnoreCase(ml.get(i).title) && ml.get(i).isIn == false)
			{
				foundBook = true;
				checkOutAlready = true;
			}
		}
		if(checkOutAlready == false)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * for testing purposes that printed out the check out list
	 */
	public void printOut()
	{
		for(int i=0; i<checkOutList.size(); i++)
		{
			System.out.print(checkOutList.get(i).title + " ");
			System.out.println(checkOutList.get(i).AccountOwner);
		}
	}
}
