package dao;

import java.util.ArrayList;

import dto.CustomerBasicInfoDTO;
import dto.PolicyInfoDTO;

public interface OperationDAO {
	public ArrayList<CustomerBasicInfoDTO> queryCustomerBasciInfoDAO();
	public CustomerBasicInfoDTO queryBasicInfoByCustomerID(String customerNo);
	public ArrayList<PolicyInfoDTO> queryPolicyInfoByCustomerID(String customerNo);
	public CustomerBasicInfoDTO updateInfoByCustomerID(String customerNo,CustomerBasicInfoDTO basic);
	public void insertNewCustomerInfo(CustomerBasicInfoDTO basic);
	public void insertNewVehicleInfo(PolicyInfoDTO policy);
	public PolicyInfoDTO queryPolicyInfoByPolicyNo(String policyNo);
	public void updatePolicyInfoByPolicyNo(PolicyInfoDTO policyInfo);
}
