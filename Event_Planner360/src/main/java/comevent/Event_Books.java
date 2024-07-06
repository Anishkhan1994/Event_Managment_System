package comevent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Event_Books implements Admin_Book{
	final String DRIVER = "com.mysql.cj.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3306/event_planner360";
	final String USERNAME = "root";
	final String PASSWORD = "881721";
	final String INSERT_QUERY = "INSERT INTO"
		     +"event_book(name, email, country, mobil, message" 
		     +"VALUES (?,?,?,?,?,)";
	final String UPDATE_QUERY = "UPDATE event_book"
		    +"SET name = ?, email = ?, country = ?, mobil = ?, message = ?"
			+ "WHERE _id = ?";
	  Connection getConnection() throws ClassNotFoundException, SQLException {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return con;
		}
	  @Override
		public int addBook(Book book) throws ClassNotFoundException, SQLException {
		    int result = 0;
		    System.out.println(book);
		    try(Connection con = getConnection();
		    		PreparedStatement pStmt = con.prepareStatement(INSERT_QUERY);){
		    	pStmt.setString(1, book.getName());
		    	pStmt.setString(2, book.getEmail());
		    	pStmt.setString(3, book.getCountry());
		    	pStmt.setLong(4, book.getMobil());
		    	pStmt.setString(5, book.getMessage());
		    	
		    	result = pStmt.executeUpdate();	
		    }
				System.out.println(book);
				return result;
		}
	  @Override
		public int modifyBook(Book book) throws ClassNotFoundException, SQLException {
			int result = 0;
			System.out.println(book);
			try (Connection con = getConnection();
					PreparedStatement pStmt = con.prepareStatement(UPDATE_QUERY);){

			pStmt.setString(1, book.getName());
		    	pStmt.setString(2, book.getEmail());
		    	pStmt.setString(3, book.getCountry());
		    	pStmt.setLong(4, book.getMobil());
		    	pStmt.setString(5, book.getMessage());
		    	
		    	result = pStmt.executeUpdate();
		    	
			}
			System.out.println(book);
			return result;
		}
	  @Override
		public int deleteBook(int bookid) throws ClassNotFoundException, SQLException {
				int result = 0;
				final String DELETE_BOOK = "DELETE FROM event_book WHERE _id=?";
				try (Connection con = getConnection();
						PreparedStatement pStmt = con.prepareStatement(DELETE_BOOK);){
					pStmt.setInt(1, bookid);
					
					result = pStmt.executeUpdate();		
				}
				return result;
	}
	  @Override
		public int getOneBook(int bookid) throws ClassNotFoundException, SQLException {
			
			final String GET_ONE_BOOK = "SELECT * FROM event_book WHERE _id = ?";
			    Book book = null;
				
				try(Connection con = getConnection();
					PreparedStatement pStmt = con.prepareStatement(GET_ONE_BOOK)){
					
					pStmt.setInt(1, bookid);	
					ResultSet rSet = pStmt.executeQuery();
					
					if(rSet.next()) {
						int id             = rSet.getInt("id");
						String name        = rSet.getString("name");
						String email       = rSet.getString("email");
						String country	   = rSet.getString("country");
						long   mobil	   = rSet.getLong("mobil");
						String message     = rSet.getString("message");
					
						book = new Book(id, name, email, country, mobil, message);
					}
				}		
				return 0;

		}
	  @Override
		public ArrayList<Book> getAllBook() throws ClassNotFoundException, SQLException {
			final String Get_All_book = "SELECT * FROM event_planner360.event_book";
			ArrayList<Book> bookList = new ArrayList<>();
			
			try (Connection con = getConnection(); Statement stmt = con.createStatement()){
				ResultSet rSet = stmt.executeQuery("SELECT * FROM event_book");
				while(rSet.next()) {
					int id              = rSet.getInt("id");
					String name         = rSet.getString("name");
					String email        = rSet.getString("email");
					String country 	    = rSet.getString("country");
					long   mobil	    = rSet.getLong("mobil");
					String message      = rSet.getString("message");
				
					
					Book book = new Book(id, name, email, country, mobil, message);
					bookList.add(book);
				}	
				
			}
	
   }
}