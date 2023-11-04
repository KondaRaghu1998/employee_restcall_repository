package com.dru.care.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dru.care.app.bean.FetchEmployeeDto;
import com.dru.care.app.bean.FetchEmployeeReq;
import com.dru.care.app.bean.InsertEmployeeReqs;
import com.dru.care.app.service.EmployeeService;
import com.dru.care.app.service.EmployeeServiceImpl;


@RestController
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	/*
	 * Using Single EndPoint for insert and update employee details with KeyHolder
	 * using NamedParameterJdbcTemplate
	 */
	@PostMapping(value = "/insertAndUpdateEmployeeWithDepartment")
	public Boolean insertAndUpdateEmployeeWithDepartment(@RequestBody InsertEmployeeReqs insertEmployeeReqs) {
		return employeeService.insertAndUpdateEmployeeWithDepartment(insertEmployeeReqs);
	}
	/*
	 * fetching particular employee details Using NamedParameter JdbcTemplate
	 */
	@PostMapping(value = "/fetchEmployeeDetailsUsingQuery")
	public List<FetchEmployeeDto> fetchEmployeeDetailsUsingQuery(
			@RequestBody FetchEmployeeReq fetchEmployeeReq) {
		return employeeService.fetchEmployeeDetailsUsingQuery(fetchEmployeeReq);
	}
	
	/*
	 * fetching particular employee department details Using NamedParameter JdbcTemplate
	 */
	@PostMapping(value = "/fecthEmployeeWithDepartmentDetailsUsingQuery")
	public List<FetchEmployeeDto> fecthEmployeeWithDepartmentDetailsUsingQuery(
			@RequestBody FetchEmployeeReq fetchEmployeeReq) {
		return employeeService.fecthEmployeeWithDepartmentDetailsUsingQuery(fetchEmployeeReq);
	}

}
