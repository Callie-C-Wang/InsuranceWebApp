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

public class InsertNewVehicle extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
	  	String customerNo =  (String)request.getParameter("customerNo");
	  	String policyNo =  (String)request.getParameter("policyNo");
	  	String vin =  (String)request.getParameter("vin");
	  	String make =  (String)request.getParameter("make");
	  	String model= (String)request.getParameter("model");
	  	String type= (String)request.getParameter("type");
	  	String cvgAmt = (String)request.getParameter("coverageAmt");
	  	int coverageAmt =  Integer.valueOf(cvgAmt).intValue();
	  	String rawYearOfMake = request.getParameter("yearOfMake");
	  	PolicyInfoDTO newPolicy = new PolicyInfoDTO();
	  	
	  	newPolicy.setCustomerNo(customerNo);
	  	newPolicy.setPolicyNo(policyNo);
	  	newPolicy.setCoverageAmt(coverageAmt);
	  	newPolicy.setVin(vin);
	  	newPolicy.setMake(make);
	  	newPolicy.setModel(model);
	  	newPolicy.setType(type);
	  	newPolicy.setRawYearOfMake(rawYearOfMake);
	  	
	  	OperationDAOImpl queryDAO = new OperationDAOImpl();
		String forwardPage = "EditCustomerDetail.do?customerNo="+customerNo;
		
		queryDAO.insertNewVehicleInfo(newPolicy);
		
		ArrayList<PolicyInfoDTO> policyInfoList = new ArrayList<PolicyInfoDTO>();
		policyInfoList = queryDAO.queryPolicyInfoByCustomerID(customerNo);
		CustomerBasicInfoDTO basciInfo = new CustomerBasicInfoDTO();
		
		request.setAttribute("policyInfoList", policyInfoList);		
		request.setAttribute("basciInfo",basciInfo);

		RequestDispatcher view = request.getRequestDispatcher(forwardPage);
		view.forward(request, response);
	}
	
	
}
