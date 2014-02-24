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
import dto.PolicyInfoDTO;

public class EditCustomerDetail extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
			CustomerBasicInfoDTO basciInfo = new CustomerBasicInfoDTO();
			ArrayList<PolicyInfoDTO> policyInfoList = new ArrayList<PolicyInfoDTO>();
		  	String customerNo =  (String)request.getParameter("customerNo");
		  	OperationDAOImpl queryDAO = new OperationDAOImpl();
			String forwardPage = "/showEditCustomerPage.jsp";
			
			basciInfo = queryDAO.queryBasicInfoByCustomerID(customerNo);
			policyInfoList = queryDAO.queryPolicyInfoByCustomerID(customerNo);
			
			request.setAttribute("policyInfoList", policyInfoList);
			request.setAttribute("basciInfo",basciInfo);

			RequestDispatcher view = request.getRequestDispatcher(forwardPage);
			view.forward(request, response);
			
	  }

}
