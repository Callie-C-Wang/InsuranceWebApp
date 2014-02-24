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

public class InsertNewCustomerBasic extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		CustomerBasicInfoDTO basciInfo = new CustomerBasicInfoDTO();
	  	String customerNo =  (String)request.getParameter("customerNo");
	  	
	  	String firstName =  (String)request.getParameter("firstName");
	  	String lastName =  (String)request.getParameter("lastName");
	  	String sex =  (String)request.getParameter("sex");
	  	String email= (String)request.getParameter("email");
	  	String mobile= (String)request.getParameter("mobile");
	  	String isAAAmtember =  (String)request.getParameter("isAAAmember");
	  	String rawBirth = request.getParameter("birth");
	  	basciInfo.setCustomerNo(customerNo);
	  	basciInfo.setFirstName(firstName);
	  	basciInfo.setLastName(lastName);
	  	basciInfo.setSex(sex);
	  	basciInfo.setEmail(email);
	  	basciInfo.setMobile(mobile);
	  	basciInfo.setIsAAAmember(isAAAmtember);
	  	basciInfo.setRawBirth(rawBirth);
	  	
	  	OperationDAOImpl queryDAO = new OperationDAOImpl();
		String forwardPage = "/showEditCustomerPage.jsp?customerNo="+customerNo;
		
		queryDAO.insertNewCustomerInfo(basciInfo);
		
		ArrayList<PolicyInfoDTO> policyInfoList = new ArrayList<PolicyInfoDTO>();
		policyInfoList = queryDAO.queryPolicyInfoByCustomerID(customerNo);
		
		request.setAttribute("policyInfoList", policyInfoList);
		
		
		request.setAttribute("basciInfo",basciInfo);

		RequestDispatcher view = request.getRequestDispatcher(forwardPage);
		view.forward(request, response);
	}
	
	
}
