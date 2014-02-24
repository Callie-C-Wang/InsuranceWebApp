package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CustomerBasicInfoDTO;

public class AddNewPsn extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		  	CustomerBasicInfoDTO newCustomer = new CustomerBasicInfoDTO();
		  	String forwardPage = "/addNewCustomer.jsp";
			
			request.setAttribute("newCustomer", newCustomer);

			RequestDispatcher view = request.getRequestDispatcher(forwardPage);
			view.forward(request, response);
			
	  }

}
