package comevent;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Admin_Book {
 	int addBook(Book book)throws ClassNotFoundException, SQLException;
	
	int modifyBook(Book book)throws ClassNotFoundException, SQLException;
	
	int deleteBook(int bookid)throws ClassNotFoundException, SQLException;
	
	int getOneBook(int bookid)throws ClassNotFoundException, SQLException;
	
	ArrayList<Book> getAllBook()throws ClassNotFoundException, SQLException;
	
}
