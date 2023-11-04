package com.dru.care.app.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dru.care.app.bean.FetchEmployeeDto;
import com.dru.care.app.bean.FetchEmployeeReq;
import com.dru.care.app.bean.InsertEmployeeReqs;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient balancerClient;

	@Value("${service.instance.name}")
	private String employeeCrudOperationApp;

	@Value("${fetch.employee.base.url}")
	private String employeeBaseUrl;

	@Value("${fetch.employee.department.base.url}")
	private String employeeDepartmentBaseUrl;
	
	@Value("${insertandupdate.emp.dep.base.url}")
	private String insertAndUpdateEmployeeDepartmentBaseUrl;

	/*
	 * ParameterizedTypeReference convert the response from the REST call into a
	 * List of FetchEmployeeDto objects.
	 */
	@SuppressWarnings("unchecked")
	public List<FetchEmployeeDto> fetchEmployeeDetailsUsingQuery(FetchEmployeeReq fetchEmployeeReq) {
		ServiceInstance serviceInstance = balancerClient.choose(employeeCrudOperationApp);
		if (serviceInstance != null) {
			String baseUrl = serviceInstance.getUri().toString();
			
			String url = baseUrl + "/" + employeeBaseUrl;// http://DESKTOP-502PMDQ:8090/employeeBaseUrl

			// Set headers
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			// Set the request body
			HttpEntity<FetchEmployeeReq> requestEntity = new HttpEntity<>(fetchEmployeeReq, headers);

			// Make the REST call
			ResponseEntity<List<FetchEmployeeDto>> responseEntity = restTemplate.exchange(url, HttpMethod.POST,
					requestEntity, new ParameterizedTypeReference<List<FetchEmployeeDto>>() {
					});

			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				return responseEntity.getBody();
			} else {
				return Collections.EMPTY_LIST;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<FetchEmployeeDto> fecthEmployeeWithDepartmentDetailsUsingQuery(FetchEmployeeReq fetchEmployeeReq) {
		ServiceInstance serviceInstance = balancerClient.choose(employeeCrudOperationApp);
		if (serviceInstance != null) {
			String baseUrl = serviceInstance.getUri().toString();
			String url = baseUrl + "/" + employeeDepartmentBaseUrl;// http://DESKTOP-502PMDQ:8090/employeeDepartmentBaseUrl

			// Set headers
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			// Set the request body
			HttpEntity<FetchEmployeeReq> requestEntity = new HttpEntity<>(fetchEmployeeReq, headers);

			// Make the REST call
			ResponseEntity<List<FetchEmployeeDto>> responseEntity = restTemplate.exchange(url, HttpMethod.POST,
					requestEntity, new ParameterizedTypeReference<List<FetchEmployeeDto>>() {
					});

			
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				return responseEntity.getBody();
			} else {
				return Collections.EMPTY_LIST;
			}

		}
		return null;
	}

	public Boolean insertAndUpdateEmployeeWithDepartment(InsertEmployeeReqs insertEmployeeReqs) {
		ServiceInstance serviceInstance = balancerClient.choose(employeeCrudOperationApp);
		if (serviceInstance != null) {
			String baseUrl = serviceInstance.getUri().toString();
			String url = baseUrl + "/" + insertAndUpdateEmployeeDepartmentBaseUrl;// http://DESKTOP-502PMDQ:8090/insertAndUpdateEmployeeDepartmentBaseUrl

			// Set headers
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			// Set the request body
			HttpEntity<InsertEmployeeReqs> requestEntity = new HttpEntity<>(insertEmployeeReqs, headers);

			// Make the REST call
			return restTemplate.postForObject(url, requestEntity, Boolean.class);
			
		}
		return null;
	}
}
