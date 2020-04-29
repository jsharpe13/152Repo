/**
 * class creates the books to be held
 * @author Jacob Sharpe
 * @version Java 8
 */
public class book implements Comparable<book>
{
	String title;
	String firstAuthor;
	String lastAuthor;
	String category;
	
	
	boolean isIn;
	String AccountOwner;
	
	/**
	 * constructor that takes in the title, authors first name
	 * author's last name, and the category of the book\
	 * @param t
	 * @param f
	 * @param l
	 * @param c
	*/
	public book(String t, String f, String l, String c)
	{
		title = t;
		firstAuthor = f;
		lastAuthor = l;
		category  = c;
		isIn = true;
		AccountOwner = null;
	}

//---------------------------------------------------------------------
	/**
	 * compares the books to but them in alpahabetical order
	 * @pram o
	*/
	@Override
	public int compareTo(book o) 
	{
		if(this.title.compareToIgnoreCase(o.title) > 0)
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}
