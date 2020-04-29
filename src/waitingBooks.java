/**
 * nodes for books on the waiting list
 * @author Jacob Sharpe
 * @version Java 8
 */
public class waitingBooks 
{
	book Book;
	String title;
	String AccountWantingBook;
	
	/**
	 * constructor that takes in the book and the account wanting the book
	 * @param Book
	 * @param Account
	 */
	public waitingBooks(book Book, String Account)
	{
		this.Book = Book;
		AccountWantingBook = Account;
		title = Book.title;
	}
}
