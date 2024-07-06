package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comevent.Admin_Book;
import comevent.Event_Books;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/editevent")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// fetching data from request object
				String bookName         =   request.getParameter("name");
				String bookEmail        =	request.getParameter("email");
				String bookCountry		=	request.getParameter("country");
				String bookMobil		=	request.getParameter("mobil");
				String bookMessage      =	request.getParameter("message");
				// printing data from the form
				System.out.println(bookName);
				System.out.println(bookEmail);
				System.out.println(bookCountry);
				System.out.println(bookMobil);
				System.out.println(bookMessage);
				// Creating Voter object
				Book book = new Book();
				    book.setName(bookName);
					book.setEmail(bookEmail);
					book.setCountry(bookCountry);
					book.setMobil(Long.parseLong(bookMobil));
					book.setMessage(bookMessage);
					Admin_Book bookcomevent= new Event_Books();
					// Invoking the votingmodels layer
					String message = "OOPs Something went wrong";
					// Passing the data to insert
					try {
						int result = bookcomevent.modifybook(book);

						// Verifying result
						if (result == 1) {
							message = "Booker Updated successfully";
							response.sendRedirect("index.dashboard.html?msg="+message);
						} else {
							message = "booker can't be updated";
							response.sendRedirect("update_dashboard.html?msg="+message);
						}

					// Handling exception
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
						response.sendRedirect("update_dashboard.html?msg="+message);
					}
				
			}

	}


