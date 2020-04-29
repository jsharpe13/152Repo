import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
/**
 * class that adds books to the right linked list
 * @author Jacob Sharpe
 * @version Java 8
 */
public class booklist 
{
	LinkedList<book> master = new LinkedList<book>();
	LinkedList<book> literature = new LinkedList<book>();
	LinkedList<book> ScienceMath = new LinkedList<book>();
	LinkedList<book> Biography = new LinkedList<book>();
	LinkedList<book> language = new LinkedList<book>();
	
	/**
	 * default constructor that calls the books in library to put all books in the right list
	*/
	public booklist()
	{
		booksinLibrary();
	}
	
	/**
	 * creates the books and puts calls on the other methods to put them in the right list
	*/
	public void booksinLibrary()
	{
		book HarryPotter1 = new book("Harry Potter: The Sorcerer's Stone", "J.K.", "Rowling", "Literature");
		book dune = new book("Dune", "Frank", "Herbert", "Literature");
		book calculus = new book("Calculus: made Easy", "Jim", "Morgan", "Math");
		book AnneDiary = new book("Diary of Anne Frank", "Anne", "Frank", "Biography");
		book Science = new book("Science of plants", "John", "Frank", "Science");
		book mylife = new book("My life", "gina", "macdonald", "Biography");
		book myjourney = new book("My journey", "sandra", "claire", "Biography");
		book spanish = new book("Learn Spanish", "lisa", "carlos", "Language");
		
		
		book list[] = {HarryPotter1,dune,calculus,
					   AnneDiary,Science,mylife,myjourney, spanish};
		
		addToMasterList(list);
		addToLiteratureList(list);
		addToScienceMathList(list);
		addToBiographyList(list);
		addToLanguageList(list);

	}
	/**
	 * adds all books to the master list
	 * @param listOfBooks
	*/
	public void addToMasterList(book listOfBooks[])
	{
		book list[] = listOfBooks;
		
		for(int i= 0; i<list.length; i++)
		{
			master.add(list[i]);
		}
		
		Collections.sort(master);
	}
	/**
	 * adds the literature books to the literature list
	 * @param listOfBooks
	*/
	public void addToLiteratureList(book listOfBooks[])
	{
		book list[] = listOfBooks;
		
		for(int i= 0; i< list.length; i++)
		{
			if(list[i].category.equalsIgnoreCase("Literature"))
			{
				literature.add(list[i]);
			}
		}
		Collections.sort(literature);
	}
	/**
	 * adds the sicence and math books to the science and math list
	 * @param listOfBooks
	*/
	public void addToScienceMathList(book listOfBooks[])
	{
		book list[] = listOfBooks;
		
		for(int i= 0; i< list.length; i++)
		{
			if(list[i].category.equalsIgnoreCase("Science") || list[i].category.equalsIgnoreCase("Math"))
			{
				ScienceMath.add(list[i]);
			}
		}
		Collections.sort(ScienceMath);
	}
	/**
	 * adds the biography books to the biography list
	 * @param listOfBooks
	*/
	public void addToBiographyList(book listOfBooks[])
	{
		book list[] = listOfBooks;
		
		for(int i= 0; i< list.length; i++)
		{
			if(list[i].category.equalsIgnoreCase("Biography"))
			{
				Biography.add(list[i]);
			}
		}
		Collections.sort(Biography);
	}
	/**
	 * adds the language books to the language list
	 * @param listOfBooks
	*/
	public void addToLanguageList(book listOfBooks[])
	{
		book list[] = listOfBooks;
		
		for(int i= 0; i< list.length; i++)
		{
			if(list[i].category.equalsIgnoreCase("Language"))
			{
				language.add(list[i]);
			}
		}
		Collections.sort(language);
	}
	
}
