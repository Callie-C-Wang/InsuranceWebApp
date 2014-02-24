package dto;

import java.util.Date;

public class PolicyInfoDTO {
	private String policyNo;
	private String customerNo;
	private int coverageAmt;
	private String vin;
	private String make;
	private String model;
	private String type;
	private Date yearOfMake;
	private String rawYearOfMake;
	
	
	public String getRawYearOfMake() {
		return rawYearOfMake;
	}
	public void setRawYearOfMake(String rawYearOfMake) {
		this.rawYearOfMake = rawYearOfMake;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public int getCoverageAmt() {
		return coverageAmt;
	}
	public void setCoverageAmt(int coverageAmt) {
		this.coverageAmt = coverageAmt;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getYearOfMake() {
		return yearOfMake;
	}
	public void setYearOfMake(Date yearOfMake) {
		this.yearOfMake = yearOfMake;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}


}
