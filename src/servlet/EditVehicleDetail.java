package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OperationDAOImpl;
import dto.CustomerBasicInfoDTO;
import dto.PolicyInfoDTO;

public class EditVehicleDetail extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		CustomerBasicInfoDTO basciInfo = new CustomerBasicInfoDTO();
		PolicyInfoDTO policyInfo = new PolicyInfoDTO();
		
	  	String customerNo =  (String)request.getParameter("customerNo");
	  	String policyNo =  (String)request.getParameter("policyNo");
	  	OperationDAOImpl queryDAO = new OperationDAOImpl();
		String forwardPage = "/showEditVehiclePage.jsp";
		
		policyInfo = queryDAO.queryPolicyInfoByPolicyNo(policyNo);
		
		basciInfo = queryDAO.queryBasicInfoByCustomerID(customerNo);
		
		request.setAttribute("policyInfo", policyInfo);
		request.setAttribute("basciInfo",basciInfo);

		RequestDispatcher view = request.getRequestDispatcher(forwardPage);
		view.forward(request, response);
		
  }

}
