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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("\n Id = " + id);
		
		int bookid = Integer.parseInt(id);
		Admin_Book bookcomevent= new Event_Books();
		String message = "";	
		try {
			int result = bookcomevent.deleteBook(bookid);
            if (result == 1) {
                message = "Booker deleted successfully";
                response.sendRedirect("index_dashboard.html?msg=" + message);
            } else {
                message = "Booker can't be deleted";
                response.sendRedirect("index_dashboard.html?msg=" + message);
            }
        } catch (SQLException | ClassNotFoundException var8) {
            message = "Something went wrong";
            response.sendRedirect("index_dashboard.html?msg=" + message);
            var8.printStackTrace();
	  }
	}

	}

}
