package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

import dto.CustomerBasicInfoDTO;
import dto.PolicyInfoDTO;

public class OperationDAOImpl implements OperationDAO {

	@Override
	public ArrayList<CustomerBasicInfoDTO> queryCustomerBasciInfoDAO() {
			ArrayList<CustomerBasicInfoDTO> resultList = new ArrayList<CustomerBasicInfoDTO>();	
			Context context;
			try {
				context = new InitialContext();
				Class.forName("com.mysql.jdbc.Driver"); 
				   
			   //equal to the command:
			   
			   //the default machine of MYSQL is :¡°127.0.0.1¡±¡£
			   //the default port of MYSQL is ¡°3306¡±
			   //format is : jdbc:mysql://[host:port],[host:port].../[database][?propertyName1][=propertyValue1][&propertyName2][=propertyValue2]...
			   
			   String url = "jdbc:mysql://localhost:3306/congdb";
			   String user = "root";
			   String pwd = "1234";
			   //get a Connection instance from JDBC
			   Connection con = DriverManager.getConnection(url, user, pwd);
			   Statement st = con.createStatement();
				   
				//using "java:comp/env" to find properties for the current Java EE component (a webapp, or an EJB).
//		        Context initContext = (Context)context.lookup("java:/comp/env");
				//using "mysqlDB" defined in context.xml to find the database configuration
//		        DataSource ds = (DataSource)initContext.lookup("mysqlDB");
//		        Connection con = ds.getConnection();
//		        Statement st = con.createStatement();
	
		        String querySentence = "select CUSTOMER_NO,FIRST_NAME,LAST_NAME,SEX,BIRTH,EMAIL,MOBILE,IS_AAA_MEMBER from congdb.CUSTOMER_INFO";
		        
		        ResultSet rs = st.executeQuery(querySentence);	  
		        
		        while (rs.next()) {
		        	  CustomerBasicInfoDTO basicInfo = new CustomerBasicInfoDTO();
		    	      String customerNo = rs.getString("CUSTOMER_NO");
		    	      String firstName = rs.getString("FIRST_NAME");
		    	      String lastName = rs.getString("LAST_NAME");
		    	      String sex = rs.getString("SEX");	    	
		    	      Date birth = rs.getDate("BIRTH");
		    	      String email = rs.getString("EMAIL");
		    	      String mobile = rs.getString("MOBILE");
		    	      String isAAAmember = rs.getString("IS_AAA_MEMBER");
		    	      basicInfo.setCustomerNo(customerNo);
		    	      basicInfo.setFirstName(firstName);
		    	      basicInfo.setLastName(lastName);
		    	      basicInfo.setSex(sex);
		    	      basicInfo.setBirth(birth);
		    	      basicInfo.setEmail(email);
		    	      basicInfo.setMobile(mobile);
		    	      basicInfo.setIsAAAmember(isAAAmember);
		    	      resultList.add(basicInfo);	    	
		        }
		        
		        con.close();
		       
		        return resultList;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return resultList;
		}
	
	

	public CustomerBasicInfoDTO queryBasicInfoByCustomerID(String para){
		
		CustomerBasicInfoDTO basicInfo = new CustomerBasicInfoDTO();
	      
		Context context;
		try {
			context = new InitialContext();
			Class.forName("com.mysql.jdbc.Driver"); 
		   String url = "jdbc:mysql://localhost:3306/congdb";
		   String user = "root";
		   String pwd = "1234";
		   //get a Connection instance from JDBC
		   Connection con = DriverManager.getConnection(url, user, pwd);
		   Statement st = con.createStatement();
		   String querySentence = "select CUSTOMER_NO,FIRST_NAME,LAST_NAME,SEX,BIRTH,EMAIL,MOBILE,IS_AAA_MEMBER from congdb.CUSTOMER_INFO where CUSTOMER_NO = '"
				   + para + "'";
		   ResultSet rs = st.executeQuery(querySentence);	
		  while(rs.next()){
			  String customerNo = rs.getString("CUSTOMER_NO");
		      String firstName = rs.getString("FIRST_NAME");
		      String lastName = rs.getString("LAST_NAME");
		      String sex = rs.getString("SEX");	    	
		      Date birth = rs.getDate("BIRTH");
		      String email = rs.getString("EMAIL");
		      String mobile = rs.getString("MOBILE");
		      String isAAAmember = rs.getString("IS_AAA_MEMBER");
		      basicInfo.setCustomerNo(customerNo);
		      basicInfo.setFirstName(firstName);
		      basicInfo.setLastName(lastName);
		      basicInfo.setSex(sex);
		      basicInfo.setBirth(birth);
		      basicInfo.setEmail(email);
		      basicInfo.setMobile(mobile);
		      basicInfo.setIsAAAmember(isAAAmember);
		  }
		  con.close();
	      return basicInfo;
	    }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return basicInfo;
	}
	
	public ArrayList<PolicyInfoDTO> queryPolicyInfoByCustomerID(String para){
		
		ArrayList<PolicyInfoDTO> policyInfoList = new ArrayList<PolicyInfoDTO>();
		Context context;
		try {
			context = new InitialContext();
			Class.forName("com.mysql.jdbc.Driver"); 
		   String url = "jdbc:mysql://localhost:3306/congdb";
		   String user = "root";
		   String pwd = "1234";
		   //get a Connection instance from JDBC
		   Connection con = DriverManager.getConnection(url, user, pwd);
		   Statement st = con.createStatement();
		   String querySentence = "select P.POLICY_NO,CUSTOMER_NO,VIN,COVERAGE_AMT,MAKE,MODEL,TYPE,YEAR_OF_MAKE from policy_info p , vehicle_info v where p.policy_no = v.policy_no and customer_no = '"
				   + para + "'";
		   ResultSet rs = st.executeQuery(querySentence);	  
		  
		   while (rs.next()) {
			  PolicyInfoDTO policyInfo = new PolicyInfoDTO();
			  String policyNo = rs.getString("POLICY_NO");
			  String customerNo = rs.getString("CUSTOMER_NO");
		      String vin = rs.getString("VIN");		
		      int coverageAmt = rs.getInt("COVERAGE_AMT");
		      String make = rs.getString("MAKE");	    	
		      String model = rs.getString("MODEL");
		      String type = rs.getString("TYPE");
		      Date yearOfMake = rs.getDate("YEAR_OF_MAKE");
		      
		      policyInfo.setPolicyNo(policyNo);
		      policyInfo.setCustomerNo(customerNo);
		      policyInfo.setVin(vin);
		      policyInfo.setCoverageAmt(coverageAmt);
		      policyInfo.setMake(make);
		      policyInfo.setModel(model);
		      policyInfo.setType(type);
		      policyInfo.setYearOfMake(yearOfMake);
		      
		      policyInfoList.add(policyInfo);
		   }
		   con.close();
	      return policyInfoList;
	      
	    }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return policyInfoList;
	
	}
	
	public CustomerBasicInfoDTO updateInfoByCustomerID(String customerNo,CustomerBasicInfoDTO basic){
		Context context;
		try {
			context = new InitialContext();
			Class.forName("com.mysql.jdbc.Driver"); 
		   String url = "jdbc:mysql://localhost:3306/congdb";
		   String user = "root";
		   String pwd = "1234";
		   //get a Connection instance from JDBC
		   Connection con = DriverManager.getConnection(url, user, pwd);
		   Statement st = con.createStatement();
		   String querySentence = "update customer_info set FIRST_NAME='"+basic.getFirstName()+
				   						 "',LAST_NAME='"+basic.getLastName()+
				   						 "',SEX='"+basic.getSex()+
				   						 "',BIRTH='"+this.transferStringToSqlDate(basic.getRawBirth())+
				   						 "',EMAIL='"+basic.getEmail()+
				   						 "',MOBILE='"+basic.getMobile()+
				   						 "',IS_AAA_MEMBER='"+basic.getIsAAAmember()+
				   						 "' where CUSTOMER_NO='"+basic.getCustomerNo()+"'";
		  st.executeUpdate(querySentence);	
		  CustomerBasicInfoDTO newInfo = this.queryBasicInfoByCustomerID(basic.getCustomerNo());
		  con.close();
		  return newInfo;
		  
	    }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return basic;
	}
	
	public void insertNewCustomerInfo(CustomerBasicInfoDTO basic){
		Context context;
		try {
			context = new InitialContext();
			Class.forName("com.mysql.jdbc.Driver"); 
		   String url = "jdbc:mysql://localhost:3306/congdb";
		   String user = "root";
		   String pwd = "1234";
		   //get a Connection instance from JDBC
		   Connection con = DriverManager.getConnection(url, user, pwd);
		   String insertSQL = "insert into customer_info"
				   +"(CUSTOMER_NO,FIRST_NAME,LAST_NAME,SEX,BIRTH,EMAIL,MOBILE,IS_AAA_MEMBER) values"
				   +"(?,?,?,?,?,?,?,?)";

		   PreparedStatement pst = (PreparedStatement) con.prepareStatement(insertSQL);
		   pst.setString(1, basic.getCustomerNo());
		   pst.setString(2, basic.getFirstName());
		   pst.setString(3, basic.getLastName());
		   pst.setString(4, basic.getSex());
		   pst.setDate(5, this.transferStringToSqlDate(basic.getRawBirth()));
		   pst.setString(6, basic.getEmail());
		   pst.setString(7, basic.getMobile());
		   pst.setString(8, basic.getIsAAAmember());

		   pst.execute();
		   con.close();
		  CustomerBasicInfoDTO newInfo = this.queryBasicInfoByCustomerID(basic.getCustomerNo());
		  
	    }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertNewVehicleInfo(PolicyInfoDTO policy){
		Context context;
		try {
			context = new InitialContext();
			Class.forName("com.mysql.jdbc.Driver"); 
		   String url = "jdbc:mysql://localhost:3306/congdb";
		   String user = "root";
		   String pwd = "1234";
		   //get a Connection instance from JDBC
		   Connection con = DriverManager.getConnection(url, user, pwd);
		   String insertPolicySql = "INSERT INTO POLICY_INFO"
				   +"(POLICY_NO,CUSTOMER_NO,COVERAGE_AMT) VALUES"
				   +"(?,?,?)";
		   
		   PreparedStatement pst_policy =  (PreparedStatement) con.prepareStatement(insertPolicySql);
		   pst_policy.setString(1, policy.getPolicyNo());
		   pst_policy.setString(2, policy.getCustomerNo());
		   pst_policy.setInt(3, policy.getCoverageAmt());
		   pst_policy.execute();
		   

		   String insertVehicleSql = "INSERT INTO VEHICLE_INFO"
					+ "(VIN, POLICY_NO, MAKE, MODEL , TYPE, YEAR_OF_MAKE) VALUES"
					+ "(?,?,?,?,?,?)";
		   
		   PreparedStatement pst_vehicle = (PreparedStatement) con.prepareStatement(insertVehicleSql);
		   pst_vehicle.setString(1, policy.getVin());
		   pst_vehicle.setString(2, policy.getPolicyNo());
		   pst_vehicle.setString(3, policy.getMake());
		   pst_vehicle.setString(4, policy.getModel());
		   pst_vehicle.setString(5, policy.getType());
		   pst_vehicle.setDate(6, transferStringToSqlDate(policy.getRawYearOfMake()));
		   pst_vehicle.execute();
		   con.close();
	    }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public PolicyInfoDTO queryPolicyInfoByPolicyNo(String para){
		PolicyInfoDTO policyInfo = new PolicyInfoDTO();
		Context context;
		try {
			context = new InitialContext();
			Class.forName("com.mysql.jdbc.Driver"); 
		   String url = "jdbc:mysql://localhost:3306/congdb";
		   String user = "root";
		   String pwd = "1234";
		   //get a Connection instance from JDBC
		   Connection con = DriverManager.getConnection(url, user, pwd);
		   Statement st = con.createStatement();
		   String querySentence = "select P.POLICY_NO,P.CUSTOMER_NO,P.COVERAGE_AMT,VIN,MAKE,MODEL,TYPE,YEAR_OF_MAKE from policy_info p, vehicle_info v where p.policy_no = v.policy_no and p.policy_no = '"
				   + para + "'";
		   ResultSet rs = st.executeQuery(querySentence);	  
		  
		   while (rs.next()) {
			  policyInfo = new PolicyInfoDTO();
			  String policyNo = rs.getString("POLICY_NO");
			  String customerNo = rs.getString("CUSTOMER_NO");
		      String vin = rs.getString("VIN");		
		      int coverageAmt = rs.getInt("COVERAGE_AMT");
		      String make = rs.getString("MAKE");	    	
		      String model = rs.getString("MODEL");
		      String type = rs.getString("TYPE");
		      Date yearOfMake = rs.getDate("YEAR_OF_MAKE");
		      
		      policyInfo.setPolicyNo(policyNo);
		      policyInfo.setCustomerNo(customerNo);
		      policyInfo.setVin(vin);
		      policyInfo.setCoverageAmt(coverageAmt);
		      policyInfo.setMake(make);
		      policyInfo.setModel(model);
		      policyInfo.setType(type);
		      policyInfo.setYearOfMake(yearOfMake);
		      
		   }
		   con.close();
	      return policyInfo;
	      
	    }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return policyInfo;	
	}

	public void updatePolicyInfoByPolicyNo(PolicyInfoDTO para){
		Context context;
		try {
			context = new InitialContext();
			Class.forName("com.mysql.jdbc.Driver"); 
		   String url = "jdbc:mysql://localhost:3306/congdb";
		   String user = "root";
		   String pwd = "1234";
		   //get a Connection instance from JDBC
		   Connection con = DriverManager.getConnection(url, user, pwd);
		   Statement st = con.createStatement();
		   String updaetPolicySentence  = "update policy_info set COVERAGE_AMT="+ para.getCoverageAmt() + " where policy_no = '"+para.getPolicyNo()+"'";
		   String updateVehicleSentence = "update vehicle_info set MAKE='"+para.getMake()+
				   						 "',MODEL='"+para.getModel()+
				   						 "',TYPE='"+para.getType()+
				   						 "',YEAR_OF_MAKE='"+this.transferStringToSqlDate(para.getRawYearOfMake())+"'";
		  st.executeUpdate(updaetPolicySentence);	
		  st.executeUpdate(updateVehicleSentence);	
		  con.close();
		  
	    }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public java.sql.Date transferStringToSqlDate(String dateString) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date javaDate = sdf.parse(dateString);
		java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
		return sqlDate;
	}
}
