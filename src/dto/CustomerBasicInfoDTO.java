package dto;

import java.util.Date;

public class CustomerBasicInfoDTO {
	private String customerNo;
	private String firstName;
	private String lastName;
	private String sex;
	private Date birth;
	private String email;
	private String mobile;
	private String isAAAmember;
	private String rawBirth;
	public String getRawBirth() {
		return rawBirth;
	}
	public void setRawBirth(String rawBirth) {
		this.rawBirth = rawBirth;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIsAAAmember() {
		return isAAAmember;
	}
	public void setIsAAAmember(String isAAAmember) {
		this.isAAAmember = isAAAmember;
	}

}
