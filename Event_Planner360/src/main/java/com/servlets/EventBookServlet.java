package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comevent.Admin_Book;
import comevent.Book;
import comevent.Event_Books;

/**
 * Servlet implementation class EventBookServlet
 */
@WebServlet("/addevents")
public class EventBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//To Request the servlet to print All method in String value 	
		String bookName        =   request.getParameter("name");
		String bookEmail       =	request.getParameter("email");
		String bookcountry     =	request.getParameter("country");
		String bookMobil       =	request.getParameter("mobil");
		String bookMessage     =	request.getParameter("message");
		
		System.out.println(bookName);
		System.out.println(bookEmail);
		System.out.println(bookcountry);
		System.out.println(bookMobil);
		System.out.println(bookMessage);

		//To convert the String value 
		Book book = new Book();
		book.setName(bookName);
		book.setEmail(bookEmail);
		book.setCountry(bookcountry);
    	book.setMobil(Long.parseLong(bookMobil));
		book.setMessage(bookMessage);
		
		System.out.println(book);
		
		 Admin_Book bookcomevent = new Event_Books();
		String message = "";	
		try {
		int result = bookcomevent.addBook(book);
			if (result == 1) {
				message ="Data is insert";
				response.sendRedirect("dashboard.jsp?msg"+message);
			} else {
				
				message = "Date can't insert";
				response.sendRedirect("index.html?msg"+message);
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Something went wrong");
			response.sendRedirect("index.html?msg"+message);
			e.printStackTrace();
		}
	}
}
