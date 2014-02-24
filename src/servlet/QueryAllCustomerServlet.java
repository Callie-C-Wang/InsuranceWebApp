package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OperationDAOImpl;
import dto.CustomerBasicInfoDTO;

public class QueryAllCustomerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		  	ArrayList<CustomerBasicInfoDTO> resultList = new ArrayList<CustomerBasicInfoDTO>();
		  	OperationDAOImpl queryDAO = new OperationDAOImpl();
			String forwardPage = "/showAllCustomers.jsp";
			
			resultList = queryDAO.queryCustomerBasciInfoDAO();
			
			if (null==resultList){
				request.setAttribute("emptyFlag",0);
			}else
				request.setAttribute("emptyFlag",1);

			request.setAttribute("resultList", resultList);

			RequestDispatcher view = request.getRequestDispatcher(forwardPage);
			view.forward(request, response);
			
	  }

}
