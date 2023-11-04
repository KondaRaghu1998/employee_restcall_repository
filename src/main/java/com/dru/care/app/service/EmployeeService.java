package com.dru.care.app.service;

import java.util.List;

import com.dru.care.app.bean.FetchEmployeeDto;
import com.dru.care.app.bean.FetchEmployeeReq;
import com.dru.care.app.bean.InsertEmployeeReqs;

public interface EmployeeService {

	Boolean insertAndUpdateEmployeeWithDepartment(InsertEmployeeReqs insertEmployeeReqs);

	List<FetchEmployeeDto> fetchEmployeeDetailsUsingQuery(FetchEmployeeReq fetchEmployeeReq);

	List<FetchEmployeeDto> fecthEmployeeWithDepartmentDetailsUsingQuery(FetchEmployeeReq fetchEmployeeReq);
	
	

}
