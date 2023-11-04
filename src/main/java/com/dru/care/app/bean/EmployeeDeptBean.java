package com.dru.care.app.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDeptBean {
	private Integer empDepId;
	private Integer empId;
	private Integer depId;
	private Integer orgId;

}
