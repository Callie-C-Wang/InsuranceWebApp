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

public class SaveVehicleDetail extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
	  	String customerNo =  (String)request.getParameter("customerNo");
	  	String policyNo =  (String)request.getParameter("policyNo");
	  	
	  	int coverageAmt = Integer.valueOf((String)request.getParameter("coverageAmt")).intValue();
	  	String make = (String)request.getParameter("make");
	  	String model = (String)request.getParameter("model"); 
	  	String type = (String)request.getParameter("type");
	  	String rawYearOfMake = (String)request.getParameter("yearOfMake");
	  	
	  	PolicyInfoDTO policyInfo = new PolicyInfoDTO();
	  	policyInfo.setPolicyNo(policyNo);
	  	policyInfo.setCoverageAmt(coverageAmt);
	  	policyInfo.setMake(make);
	  	policyInfo.setModel(model);
	  	policyInfo.setType(type);
	  	policyInfo.setRawYearOfMake(rawYearOfMake);
	  	OperationDAOImpl queryDAO = new OperationDAOImpl();
		String forwardPage = "/showEditCustomerPage.jsp?customerNo="+customerNo;
		
		queryDAO.updatePolicyInfoByPolicyNo(policyInfo);
		
		CustomerBasicInfoDTO basciInfo = new CustomerBasicInfoDTO();
		ArrayList<PolicyInfoDTO> policyInfoList = new ArrayList<PolicyInfoDTO>();
		policyInfoList = queryDAO.queryPolicyInfoByCustomerID(customerNo);
		basciInfo = queryDAO.queryBasicInfoByCustomerID(customerNo);
		
		request.setAttribute("policyInfoList", policyInfoList);		
		request.setAttribute("basciInfo",basciInfo);

		RequestDispatcher view = request.getRequestDispatcher(forwardPage);
		view.forward(request, response);
	}
	
	
}
