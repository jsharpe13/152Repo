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
/**
 * prints the different books list when called
 * @author Jacob Sharpe
 * @version Java 8
 */
public class printAllBooks 
{
	booklist bl;
	Scanner input = new Scanner(System.in);
	
	/**
	 * constructor that takes in the booklist t print out the different lists
	 * @param bl
	 */
	public printAllBooks(booklist bl)
	{
		this.bl = bl;
	}
	/**
	 * JFrame that allows the user to choose which category to print out
	 */
	public void getCategoryList()
	{
		JFrame categorySelection = new JFrame("category selection");
		categorySelection.setSize(500,300);
		categorySelection.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		categorySelection.setVisible(true);
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setPreferredSize(new Dimension(500,300));
		categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.PAGE_AXIS));
		categorySelection.add(categoryPanel);
		
		JLabel whatcategory = new JLabel("What category of books do you want to look up?");
		whatcategory.setAlignmentX(Component.CENTER_ALIGNMENT);
		categoryPanel.add(whatcategory);
		JLabel empty1 = new JLabel(" ");
		empty1.setAlignmentX(Component.CENTER_ALIGNMENT);
		categoryPanel.add(empty1);
		
		JButton button1 = new JButton("Literature");
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printLiterature();
			}
		});
		
		JButton button2 = new JButton("Science/Math");
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printScienceMath();
			}
		});
		
		JButton button3 = new JButton("Biography");
		button3.setAlignmentX(Component.CENTER_ALIGNMENT);
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printBiography();
			}
		});
		
		JButton button4 = new JButton("Language");
		button4.setAlignmentX(Component.CENTER_ALIGNMENT);
		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printLanguage();
			}
		});

		categoryPanel.add(button1);
		JLabel empty2 = new JLabel(" ");
		empty2.setAlignmentX(Component.CENTER_ALIGNMENT);
		categoryPanel.add(empty2);
		categoryPanel.add(button2);
		JLabel empty3 = new JLabel(" ");
		empty3.setAlignmentX(Component.CENTER_ALIGNMENT);
		categoryPanel.add(empty3);
		categoryPanel.add(button3);
		JLabel empty4 = new JLabel(" ");
		empty4.setAlignmentX(Component.CENTER_ALIGNMENT);
		categoryPanel.add(empty4);
		categoryPanel.add(button4);
	}
	
	
	/**
	 * JFrame that prints out the master list
	 */
	public void printMasters()
	{
		String result = "<html>" + "" + "<br><html>";
		result = "<html>" + result + "All Books" + "<br><html>";
		
		for(book b: bl.master)
		{
			result = "<html>" + result + "" + "<br><html>";
			result = "<html>" + result + "Title: " + b.title + "<br><html>";
			result = "<html>" + result + "by: " + b.firstAuthor + " " + b.lastAuthor + "<br><html>";
			result = "<html>" + result + "category: " + b.category + "<br><html>";
			result = "<html>" + result + "Avilable: " + b.isIn + "<br><html>";
			result = "<html>" + result + "<br><html>";
		}
		
		JFrame masterListBooks = new JFrame("All books");
		masterListBooks.setSize(500, 825);
		masterListBooks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		masterListBooks.setVisible(true);
		
		JPanel listPanel = new JPanel();
		listPanel.setPreferredSize(new Dimension(500,825));
		JLabel list = new JLabel(result);
		list.setAlignmentX(Component.CENTER_ALIGNMENT);
		listPanel.add(list);
		
		masterListBooks.add(listPanel);
	}
	/**
	 * JFrame that prints out the literature list
	 */
	public void printLiterature()
	{
		String result = "<html>" + "" + "<br><html>";
		result = "<html>" + result + "Literature" + "<br><html>";
		
		for(book b: bl.literature)
		{
			result = "<html>" + result + "" + "<br><html>";
			result = "<html>" + result + "Title: " + b.title + "<br><html>";
			result = "<html>" + result + "by: " + b.firstAuthor + " " + b.lastAuthor + "<br><html>";
			result = "<html>" + result + "category: " + b.category + "<br><html>";
			result = "<html>" + result + "Avilable: " + b.isIn + "<br><html>";
			result = "<html>" + result + "<br><html>";
		}
		JFrame LiteratureListBooks = new JFrame("All books");
		LiteratureListBooks.setSize(500, 500);
		LiteratureListBooks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		LiteratureListBooks.setVisible(true);
		
		JPanel listPanel = new JPanel();
		listPanel.setPreferredSize(new Dimension(500,500));
		JLabel list = new JLabel(result);
		list.setAlignmentX(Component.CENTER_ALIGNMENT);
		listPanel.add(list);
		
		LiteratureListBooks.add(listPanel);
	}
	/**
	 * JFrame that prints out the science and math list
	 */
	public void printScienceMath()
	{
		String result = "<html>" + "" + "<br><html>";
		result = "<html>" + result + "Science/Math" + "<br><html>";
		
		for(book b: bl.ScienceMath)
		{
			result = "<html>" + result + "" + "<br><html>";
			result = "<html>" + result + "Title: " + b.title + "<br><html>";
			result = "<html>" + result + "by: " + b.firstAuthor + " " + b.lastAuthor + "<br><html>";
			result = "<html>" + result + "category: " + b.category + "<br><html>";
			result = "<html>" + result + "Avilable: " + b.isIn + "<br><html>";
			result = "<html>" + result + "<br><html>";
		}
		JFrame ScienceListBooks = new JFrame("All books");
		ScienceListBooks.setSize(500, 500);
		ScienceListBooks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ScienceListBooks.setVisible(true);
		
		JPanel listPanel = new JPanel();
		listPanel.setPreferredSize(new Dimension(500,500));
		JLabel list = new JLabel(result);
		list.setAlignmentX(Component.CENTER_ALIGNMENT);
		listPanel.add(list);
		
		ScienceListBooks.add(listPanel);
	}
	/**
	 * JFrame that prints out the biography list
	 */
	public void printBiography()
	{
		String result = "<html>" + "" + "<br><html>";
		result = "<html>" + result + "Biography" + "<br><html>";
		
		for(book b: bl.Biography)
		{
			result = "<html>" + result + "" + "<br><html>";
			result = "<html>" + result + "Title: " + b.title + "<br><html>";
			result = "<html>" + result + "by: " + b.firstAuthor + " " + b.lastAuthor + "<br><html>";
			result = "<html>" + result + "category: " + b.category + "<br><html>";
			result = "<html>" + result + "Avilable: " + b.isIn + "<br><html>";
			result = "<html>" + result + "<br><html>";
		}
		JFrame BiographyBooks = new JFrame("All books");
		BiographyBooks.setSize(500, 500);
		BiographyBooks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		BiographyBooks.setVisible(true);
		
		JPanel listPanel = new JPanel();
		listPanel.setPreferredSize(new Dimension(500,500));
		JLabel list = new JLabel(result);
		list.setAlignmentX(Component.CENTER_ALIGNMENT);
		listPanel.add(list);
		
		BiographyBooks.add(listPanel);
	}
	/**
	 * JFrame that prints out the language list
	 */
	public void printLanguage()
	{
		String result = "<html>" + "" + "<br><html>";
		result = "<html>" + result + "Language" + "<br><html>";
		
		for(book b: bl.language)
		{
			result = "<html>" + result + "" + "<br><html>";
			result = "<html>" + result + "Title: " + b.title + "<br><html>";
			result = "<html>" + result + "by: " + b.firstAuthor + " " + b.lastAuthor + "<br><html>";
			result = "<html>" + result + "category: " + b.category + "<br><html>";
			result = "<html>" + result + "Avilable: " + b.isIn + "<br><html>";
			result = "<html>" + result + "<br><html>";
		}
		JFrame LanguageBooks = new JFrame("All books");
		LanguageBooks.setSize(500, 500);
		LanguageBooks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		LanguageBooks.setVisible(true);
		
		JPanel listPanel = new JPanel();
		listPanel.setPreferredSize(new Dimension(500,500));
		JLabel list = new JLabel(result);
		list.setAlignmentX(Component.CENTER_ALIGNMENT);
		listPanel.add(list);
		
		LanguageBooks.add(listPanel);
	}
}
